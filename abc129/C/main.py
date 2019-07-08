MOD = 1000000007
N = 100001

fibo = [1, 1] + [0] * N
for i in range(2, N):
    fibo[i] = (fibo[i - 1] + fibo[i - 2]) % MOD

n, m = list(map(int, input().split(" ")))
a_list = [int(input()) for _ in range(m)]
is_ngs = [0] * (n + 2)
for a in a_list:
    is_ngs[a] = 1
for i in range(n):
    if is_ngs[i] and is_ngs[i + 1]:
        print(0)
        exit()
cnts = []
cnt = 0

for i in range(n + 1):
    if is_ngs[i]:
        cnts.append(cnt)
        cnt = 0
        continue
    cnt += 1
cnts.append(cnt)
ans = 1
for c in cnts:
    if c != 0:
        ans *= fibo[c - 1]
# print(is_ngs)
# print(cnts)
print(ans % MOD)
