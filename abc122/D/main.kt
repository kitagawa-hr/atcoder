
import java.io.*
import java.util.*

val pw = PrintWriter(System.out)
const val MOD = 1000000007L

fun isOK(last4: String): Boolean {
    val regex = "AGC|AG.C|A.GC|GAC|ACG".toRegex()
    return !regex.containsMatchIn(last4)
}

fun solve(N: Int) {
    // dp[i][s] i文字で最後の三文字がsなものの総数
    val dp = Array<MutableMap<String, Long>>(N + 1) { mutableMapOf<String, Long>() }
    for (i in "AGCT") {
        for (j in "AGCT") {
            for (k in "AGCT") {
                val s = listOf(i, j, k).joinToString(separator = "")
                if (isOK(s)) dp[3][s] = 1L
            }
        }
    }
    for (i in 4..N) {
        for (j in dp[i - 1].keys) {
            for (k in "AGCT") {
                val last4 = j + k.toString()
                if (isOK(last4)) {
                    val last3 = last4.drop(1)
                    dp[i][last3] = (dp[i].getOrElse(last3){ 0 } + dp[i - 1][j]!!) % MOD
                }
            }
        }
    }
    // println(dp[N])
    println(dp[N].map { it.value }.sum() % MOD)
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
    solve(N)
}
