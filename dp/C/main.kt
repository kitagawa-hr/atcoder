import java.io.*
import java.util.*

const val A = 0
const val B = 1
const val C = 2
fun solve(N: Int, a: IntArray, b: IntArray, c: IntArray) {
    val dp = Array(3) { LongArray(N) }
    dp[A][0] = a[0].toLong()
    dp[B][0] = b[0].toLong()
    dp[C][0] = c[0].toLong()
    for (i in 1 until N) {
        dp[A][i] = a[i] + Math.max(dp[B][i - 1], dp[C][i - 1])
        dp[B][i] = b[i] + Math.max(dp[C][i - 1], dp[A][i - 1])
        dp[C][i] = c[i] + Math.max(dp[A][i - 1], dp[B][i - 1])
    }
    // for (i in 0 until N){
    //     println("${dp[A][i]} ${dp[B][i]} ${dp[C][i]}")
    // }
    val ans = setOf(dp[A][N - 1], dp[B][N - 1], dp[C][N - 1]).max()!!
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
    val a = IntArray(N)
    val b = IntArray(N)
    val c = IntArray(N)
    for (i in 0 until N) {
        a[i] = sc.next().toInt()
        b[i] = sc.next().toInt()
        c[i] = sc.next().toInt()
    }
    solve(N, a, b, c)
}
