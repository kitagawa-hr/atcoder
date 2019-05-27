from itertools import product


def count(ss, ns, ps):
    for i, s in enumerate(ss):
        sum_s = sum([ns[_s - 1] for _s in s])
        if sum_s % 2 != ps[i]:
            return 0
    return 1


n, m = list(map(int, input().split(" ")))
ks = []
ss = []
for _ in range(m):
    k, *s = list(map(int, input().split(" ")))
    ks.append(k)
    ss.append(s)
ps = list(map(int, input().split(" ")))

ns_list = list(product([0, 1], repeat=n))
ans = 0
for ns in ns_list:
    ans += count(ss, ns, ps)
print(ans)
