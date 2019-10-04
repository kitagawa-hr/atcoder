import java.io.*
import java.util.*

fun solve(N: Int, K: Int, h: IntArray) {
    val dp = LongArray(N)
    for (i in 1 until N) {
        var ret = Long.MAX_VALUE
        for (j in 1..K) {
            if (i - j < 0) continue
            ret = Math.min(ret, dp[i - j] + Math.abs(h[i - j] - h[i]))
        }
        dp[i] = ret
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
    val K = sc.next().toInt()
    val h = IntArray(N)
    for (i in 0 until N) {
        h[i] = sc.next().toInt()
    }
    solve(N, K, h)
}
