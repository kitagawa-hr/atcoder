import java.io.*
import java.util.*

fun solve(N: Int, a: IntArray) {
    // dp[i][j] = 部分列a[i, j)におけるX-Y(i < j)
    // + or - max(a[i], a[j-1])
    // ans = dp[0][N] = dp[0][N-1], dp[1][N]
    val dp = Array(N) { LongArray(N) }
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
    val a = IntArray(N)
    for (i in 0 until N) {
        a[i] = sc.next().toInt()
    }
    solve(N, a)
}
