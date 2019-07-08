#!/usr/bin/env python3
import sys
from collections import defaultdict, deque


class Node:
    def __init__(self, label, index):
        self.label = label
        self.index = index

    def __eq__(self, other):
        return (self.label == other.label) and (self.index == other.index)

    def __str__(self):
        return "(" + ",".join(map(str, [self.label, self.index])) + ")"

    def __repr__(self):
        return self.__str__()


def solve(N: int, M: int, u: "List[int]", v: "List[int]", S: int, T: int):
    if M == 0:
        print(-1)
        return
    a = defaultdict(list)
    b = defaultdict(list)
    c = defaultdict(list)
    edge = [a, b, c]
    for i in range(M):
        edge[0][u[i]].append(Node(1, v[i]))
        edge[1][u[i]].append(Node(2, v[i]))
        edge[2][u[i]].append(Node(0, v[i]))
    start_node = Node(0, S)
    end_node = Node(0, T)

    class BFSearch:
        def __init__(self):
            self.queue = deque()
            a = [0] * (M + 1)
            b = [0] * (M + 1)
            c = [0] * (M + 1)
            self.steps = [a, b, c]

        def search(self, node):
            self.queue.append(node)
            while self.queue:
                node_now = self.queue.popleft()
                step_now = self.steps[node_now.label][node_now.index]
                next_nodes = edge[node_now.label][node_now.index]
                for next_node in next_nodes:
                    s = self.steps[next_node.label][next_node.index]
                    if s > 0:
                        continue
                    if next_node == end_node:
                        return step_now + 1
                    self.steps[next_node.label][next_node.index] = step_now + 1
                    self.queue.append(next_node)
            return -1

    dfs = BFSearch()
    ans = dfs.search(start_node)
    print(ans // 3 if ans % 3 == 0 else -1)
    return


# Generated by 1.1.4 https://github.com/kyuridenamida/atcoder-tools  (tips: You use the default template now. You can remove this line by using your custom template)
def main():
    def iterate_tokens():
        for line in sys.stdin:
            for word in line.split():
                yield word

    tokens = iterate_tokens()
    N = int(next(tokens))  # type: int
    M = int(next(tokens))  # type: int
    u = [int()] * (M)  # type: "List[int]"
    v = [int()] * (M)  # type: "List[int]"
    for i in range(M):
        u[i] = int(next(tokens))
        v[i] = int(next(tokens))
    S = int(next(tokens))  # type: int
    T = int(next(tokens))  # type: int
    solve(N, M, u, v, S, T)


if __name__ == "__main__":
    main()
