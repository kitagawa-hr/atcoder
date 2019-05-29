from collections import Counter

n = int(input())
a_list = list(map(int, input().split(" ")))
c = Counter(a_list)

ans = 0
for k in c.keys():
    tmp = c[k]
    if k + 1 in c.keys():
        tmp += c[k + 1]
    if k - 1 in c.keys():
        tmp += c[k - 1]
    ans = max(ans, tmp)
print(ans)

