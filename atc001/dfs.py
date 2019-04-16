from collections import defaultdict

import numpy as np
import sys

sys.setrecursionlimit(1000000)


def dfs(x, y):
    # Out of range
    if any([x < 0, y < 0, x >= w, y >= h]) or c[y][x] == "#" or cache[y][x]:
        return False
    cache[y][x] = 1
    if c[y][x] == "g":
        return True
    return dfs(x + 1, y) or dfs(x - 1, y) or dfs(x, y + 1) or dfs(x, y - 1)


h, w = list(map(int, input().split(" ")))
cache = np.zeros((h, w), dtype="int64")

c = []
for _ in range(h):
    c.append(input())
for x in range(w):
    for y in range(h):
        if c[y][x] == "s":
            start = (x, y)
if dfs(*start):
    print("Yes")
else:
    print("No")
