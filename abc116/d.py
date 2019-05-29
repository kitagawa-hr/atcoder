from itertools import permutations


def calc_point(types, points):
    return len(list(set(types)))**2 + sum(points)


n, k = list(map(int, input().split(" ")))
ts = []
ds = []
for _ in range(n):
    t, d = list(map(int, input().split(" ")))
    ts.append(t)
    ds.append(d)

print(calc_point(ts[:3], ds[:3]))
