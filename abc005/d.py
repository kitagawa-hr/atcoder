from itertools import product, chain
from functools import lru_cache
import math

import numpy as np


def cumsum_2d(d_list, x, y):
    return sum([sum(d[: x + 1]) for d in d_list[: y + 1]])


def s_2d(x1, y1, x2, y2, s):
    return s[x2, y2] - s[x1, y2] -s[x2, y1] + s[x1, y1]


def solve(n, p, cumsum, squares):
    ans = 0
    for x, y in squares:
        for i, j in product(range(n - x), range(n - y)):
            ans = max(ans, s_2d(i , j , x + i , y + j , cumsum))
    return ans


if __name__ == "__main__":
    n = int(input())
    d_list = []
    for _ in range(n):
        d_list.append(list(map(int, input().split(" "))))
    cumsum = np.empty((n, n), dtype=np.int32)
    for x in range(n):
        for y in range(n):
            cumsum[x][y] = cumsum_2d(d_list, x, y)
    products = [(x, y, x * y) for x, y in product(range(1, n + 1), repeat=2)]
    q = int(input())
    for _ in range(q):
        p = int(input())
        if p == 1:
            print(max(chain.from_iterable(d_list)))
            continue
        squares = [(x, y) for x, y, s in products if s <= p]
        print(solve(n, p, cumsum, squares))
