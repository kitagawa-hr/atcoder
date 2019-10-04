import java.io.*
import java.util.*

fun solve(N: Int, h: IntArray) {
    // dp[i] = iにたどり着くまでのコストの最小値
    val dp = IntArray(N)
    dp[0] = 0
    dp[1] = Math.abs(h[1] - h[0])
    for (i in 2 until N) {
        dp[i] = Math.min(
            dp[i - 1] + Math.abs(h[i - 1] - h[i]),
            dp[i - 2] + Math.abs(h[i - 2] - h[i])
        )
    }
    println(dp[N - 1])
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
    val h = IntArray(N)
    for (i in 0 until N) {
        h[i] = sc.next().toInt()
    }
    solve(N, h)
}
