import java.io.*
import java.util.*

const val INF = 10000000000L
const val VMAX = 100007
fun solve(N: Int, W: Int, w: IntArray, v: IntArray) {
    // dp[i][v] = iまで使って価値vとなる最小の重さ
    // dp[i][v] = Math.min(dp[i-1][v], dp[i-1][v-v[i]] + w[i])
    val dp = Array(N) { LongArray(VMAX) { INF } }
    for (i in 0 until N) { dp[i][0] = 0 }
    dp[0][v[0]] = w[0].toLong()
    for (i in 1 until N) {
        for (j in 0 until VMAX) {
            dp[i][j] = Math.min(
                dp[i - 1][j],
                dp[i - 1].getOrElse(j - v[i]) { INF } + w[i]
            )
        }
    }
    val ans = dp[N - 1].indexOfLast { it <= W } ?: 0
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
    val W = sc.next().toInt()
    val w = IntArray(N.toInt())
    val v = IntArray(N.toInt())
    for (i in 0 until N.toInt()) {
        w[i] = sc.next().toInt()
        v[i] = sc.next().toInt()
    }
    solve(N, W, w, v)
}
