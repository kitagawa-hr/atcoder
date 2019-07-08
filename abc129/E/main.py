MOD = int(10 ** 9 + 7)
L = input()
dp1 = [0] * len(L)
# always under L
dp2 = [0] * len(L)
# 00
dp1[0] = 1
# 10 01
dp2[0] = 2
for i, s in enumerate(L):
    if i == 0:
        continue
    # 01 10 00
    if s == "1":
        # 01 10
        dp2[i] = dp2[i - 1] * 2
        # 00
        dp1[i] = dp1[i - 1] * 3 + dp2[i - 1] * 1
    else:
        # 00
        dp2[i] = dp2[i - 1] * 1
        dp1[i] = dp1[i - 1] * 3
    dp1[i] %= MOD
    dp2[i] %= MOD
n = len(L)
print((dp1[n - 1] + dp2[n - 1]) % MOD)
