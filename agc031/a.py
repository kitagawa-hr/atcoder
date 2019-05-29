from collections import Counter

MOD = 10e9 + 7

n = int(input())
s = input()
count = Counter(s)
minus = 1
for c in count.values():
    if c >= 2:
        minus *= c + 1
ans = (2 ** len(s) - minus) % MOD
print(int(ans))
