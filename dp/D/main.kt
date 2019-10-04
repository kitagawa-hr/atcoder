import java.io.*
import java.util.*

const val INF = 10000000000L
fun solve(N: Int, W: Int, w: IntArray, v: IntArray) {
    // dp[i][w] = iまで用いて重さwのときの最大の価値
    // dp[i][w] = max(dp[i-1][w], dp[i-1][w-w[i]] + v[i])
    val dp = Array(N) { LongArray(W + 1) { -INF } }
    dp[0][0] = 0
    dp[0][w[0]] = v[0].toLong()
    for (i in 1 until N) {
        for (j in 0..W) {
            dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1].getOrElse(j - w[i]) { -INF } + v[i])
        }
    }
    println(dp[N - 1].max()!!)
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
    val W = sc.next().toInt()
    val w = IntArray(N)
    val v = IntArray(N)
    for (i in 0 until N) {
        w[i] = sc.next().toInt()
        v[i] = sc.next().toInt()
    }
    solve(N, W, w, v)
}
