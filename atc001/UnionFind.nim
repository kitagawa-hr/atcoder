import strutils, sequtils


var
  tmp = (split readLine stdin).map(parseInt)
  (N, Q) = (tmp[0], tmp[1])
  nodes = newSeqWith(N, 0)

proc get_root(nodes: seq[int], x: int) : int=
    if nodes[x] < 0:
        return x
    else:
        nodes[x] = get_root(nodes, nodes[x])
        return nodes[x]


proc unite(nodes: seq[int], x: int, y: int) : int=
    var (root_x, root_y) = (get_root(nodes, x), get_root(nodes, y))
    var bigroot, smallroot: int
    if root_x != root_y:
        if nodes[root_x] < nodes[root_y]:
            (bigroot, smallroot)= (root_x, root_y)
        else:
            (bigroot, smallroot)= (root_y, root_x)

        nodes[bigroot] += nodes[smallroot]
        nodes[smallroot] = bigroot
    return 0

for _ in 0 ..< Q:
    tmp = (split readLine stdin).map(parseInt)
    let (p, a, b) = (tmp[0], tmp[1], tmp[2])
    if p == 0:
        discard unite(nodes, a, b)
    else:
        if get_root(nodes, a) == get_root(nodes, b):
            echo "Yes"
        else:
            echo "No"
