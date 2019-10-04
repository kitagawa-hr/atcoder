from io import StringIO


UP = 0
LEFT = 1
LEFTUP = 2


def lcs(s, t):
    m = len(s)
    n = len(t)
    # dp[i][j] = LCS-length of (s[:i], t[:j])
    dp = [[0] * (n + 1) for i in range(m + 1)]

    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if s[i - 1] == t[j - 1]:
                dp[i][j] = dp[i - 1][j - 1] + 1
            else:
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
    buf = StringIO()
    i = m
    j = n
    while i > 0 and j > 0:
        if dp[i][j] == dp[i - 1][j]:
            i -= 1
        elif dp[i][j] == dp[i][j - 1]:
            j -= 1
        elif dp[i][j] == dp[i - 1][j - 1] + 1:
            buf.write(s[i - 1])
            i -= 1
            j -= 1
    buf.seek(0)
    ans = buf.read()[::-1]
    return ans


if __name__ == "__main__":
    print(lcs(input(), input()))
