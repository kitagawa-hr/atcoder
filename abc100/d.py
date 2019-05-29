from itertools import product

import numpy as np

n, m = list(map(int, input().split(" ")))
if m == 0:
    print(0)
    exit()
xyz_list = []
for _ in range(n):
    xyz_list.append(np.array(list(map(int, input().split(" ")))))
arrs = [np.array(x) for x in product([1, -1], repeat=3)]
ans = max([sum(sorted([sum(arr * xyz) for xyz in xyz_list])[-m:]) for arr in arrs])
print(ans)
