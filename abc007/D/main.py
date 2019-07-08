def digit_dp(n):
    """n以下の4または9を含む数字について探索"""
    # dp[n未満確定か][決定した桁数][4 or 9を含むか]
    dp = [[[0, 0]] * (len(n) + 1)] * 2
    digit = int(n[0])
    dp[0][0][0] = 1
    for i in range(len(n) - 1):
        digit = int(n[i + 1])
        for j in range(2):
            for k in range(2):
                D = 9 if j else digit
                for d in range(digit):
                    dp[j or (d < D)][i + 1][k or d == 4 or d == 9] += dp[i][j][k]
    return dp[0][len(n)][1] + dp[1][len(n)][1]


sA, sB = input().split(" ")
ans = digit_dp(sB) - digit_dp(str(int(sA) - 1))
print(ans)
