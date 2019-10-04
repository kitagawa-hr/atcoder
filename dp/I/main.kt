import java.io.*
import java.util.*

// ans = [p_i][1-p_j]
fun solve(N: Int, p: DoubleArray) {
    // dp[i][j] iまで使って, j枚表になる確率
    // dp[i][j] = dp[i-1][j] * (1-p[i]) + dp[i-1][j-1] * p[i]
    val dp = Array(N) { DoubleArray(N + 1) }
    dp[0][0] = 1 - p[0]
    dp[0][1] = p[0]
    for (i in 1 until N) {
        for (j in 0..i + 1) {
            dp[i][j] = dp[i - 1][j] * (1 - p[i]) + dp[i - 1].getOrElse(j - 1) { 0.toDouble() } * p[i]
        }
    }
    val ans = dp[N - 1].filterIndexed { index, value -> index > N / 2 }.sum()
    println(ans)
    return
}

fun main(args: Array<String>) {
    fun StringArray(size: Int, init: (Int) -> String = { "\u0000" }): Array<String> {
        return Array<String>(size, init)
    }
    class Scanner(stream: InputStream) {
        private val reader = BufferedInputStream(stream).bufferedReader()
        private var st: StringTokenizer? = null
        fun next(): String {
            while (!(st?.hasMoreTokens() ?: false)) st = StringTokenizer(reader.readLine())
            return st!!.nextToken()
        }
    }
    val sc = Scanner(System.`in`)
    val N = sc.next().toInt()
    val p = DoubleArray(N)
    for (i in 0 until N.toInt()) {
        p[i] = sc.next().toDouble()
    }
    solve(N, p)
}
