@Suppress("UNUSED_PARAMETER")
fun main(args: Array<String>) {
    val L: String = readLine()!!
    solve(L)
}

fun solve(L: String) {
    val MOD: Long = (1E9 + 7).toLong()
    var dp1 = LongArray(L.length)
    var dp2 = LongArray(L.length)
    var dp: Array<LongArray> = arrayOf(dp1, dp2)
    dp[0][0] = 1
    dp[1][0] = 2
    for (i in 1 until L.length) {
        if (L[i] == '1') {
            dp[1][i] = dp[1][i - 1] * 2
            dp[0][i] = dp[0][i - 1] * 3 + dp[1][i - 1] * 1
        } else {
            dp[1][i] = dp[1][i - 1] * 1
            dp[0][i] = dp[0][i - 1] * 3
        }
        dp[0][i] %= MOD
        dp[1][i] %= MOD
    }
    println((dp[0][L.length - 1] + dp[1][L.length - 1 ])%MOD)
}
