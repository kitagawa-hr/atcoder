import java.io.*
import java.util.*

var pw = PrintWriter(System.out)
fun solve(N: Int, A: IntArray) {
    val dp = LongArray(N)
    dp[0] = 2L * A[N - 1]
    for (i in 1 until N) {
        dp[i] = 2L * A[i - 1] - dp[i - 1]
    }
    val a = dp[N - 1] / 2L
    for (i in 0 until N - 1) {
        if (i % 2 == 0) {
            pw.print(dp[i] - a)
        } else {
            pw.print(dp[i] + a)
        }
        pw.print(" ")
    }
    pw.println(a)
    pw.flush()
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
    val A = IntArray(N)
    for (i in 0 until N) {
        A[i] = sc.next().toInt()
    }
    solve(N, A)
}
