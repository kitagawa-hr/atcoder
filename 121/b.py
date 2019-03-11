from operator import mul
from functools import reduce

n, m, c = list(map(int, input().split(" ")))
bs = list(map(int, input().split(" ")))
a_nm = []
for _ in range(n):
    a_m = list(map(int, input().split(" ")))
    a_nm.append(a_m)

ans = 0
tested = [sum([a * b for a, b in zip(a_nm[i], bs)]) + c for i in range(n)]
passed = list(filter(lambda x: x > 0, tested))
print(len(passed))
