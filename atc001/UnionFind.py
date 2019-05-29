def get_root(nodes, x: int) -> int:
    if nodes[x] < 0:
        return x
    else:
        nodes[x] = get_root(nodes, nodes[x])
        return nodes[x]


def unite(nodes, x: int, y: int) -> None:
    root_x, root_y = get_root(nodes, x), get_root(nodes, y)
    if root_x != root_y:
        bigroot, smallroot = (
            (root_x, root_y) if nodes[root_x] < nodes[root_y] else (root_y, root_x)
        )
        nodes[bigroot] += nodes[smallroot]
        nodes[smallroot] = bigroot


N, Q = list(map(int, input().split(" ")))
nodes = [-1] * N
result = []
for _ in range(Q):
    p, a, b = list(map(int, input().split(" ")))
    if p == 0:
        unite(nodes, a, b)
    else:
        result.append("YNeos"[not get_root(nodes, a) == get_root(nodes, b) :: 2])
print(*result, sep="\n")
