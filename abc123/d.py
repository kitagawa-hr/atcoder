from itertools import product, chain
from collections import deque


def solver1(a, b, c, k):
    apb_sorted = sorted([a + b for a, b in product(a, b)])[-k:]
    ans_list = sorted(
        list(chain.from_iterable([[_c + ab for ab in apb_sorted] for _c in c[:k]]))
    )
    it = reversed(ans_list)
    for _ in range(k):
        print(next(it))


def solver2(a, b, c, k):
    n = len(a)
    m = min(k, n)
    pqr = deque()
    for p in range(m):
        for q in range(m):
            for r in range(m):
                if (p + 1) * (q + 1) * (r + 1) > k:
                    break
                else:
                    pqr.append(a[-p - 1] + b[-q - 1] + c[-r - 1])
    it = reversed(sorted(pqr))
    for _ in range(k):
        print(next(it))


if __name__ == "__main__":
    x, y, z, k = list(map(int, input().split(" ")))
    a = sorted(list(map(int, input().split(" "))))
    b = sorted(list(map(int, input().split(" "))))
    c = sorted(list(map(int, input().split(" "))))
    solver2(a, b, c, k)
