import java.io.*
import java.util.*

fun solve(N: Int, M: Int, A: IntArray) {
    val matchMap = mapOf(
        1 to 2,
        2 to 5,
        3 to 5,
        4 to 4,
        5 to 5,
        6 to 6,
        7 to 3,
        8 to 7,
        9 to 6
    )
    // ちょうどi本使って作れる最大の桁数
    val dp = IntArray(N + 1){ -1 }
    dp[0] = 0
    for (i in 1..N) {
        for (a in A){
            val m = matchMap[a]!!
            if (i - m < 0) continue
            if (dp[i-m] < 0) continue
            dp[i] = Math.max(dp[i], 1 + dp[i - m])
        }
    }
    // println(dp.contentToString())
    val ans = mutableListOf<Int>()
    val digit = dp[N]
    var rest = N
    val matcheDigits = A.sortedDescending()
    for (i in 0 until digit) {
        for (matchDigit in matcheDigits){
            val matchNum = matchMap[matchDigit]!!
            if (dp.getOrNull(rest - matchNum) == dp[rest] - 1) {
                ans.add(matchDigit)
                rest -= matchNum
                break
            }
            // println(rest)
        }
    }
    println(ans.joinToString(separator = ""))
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
    val M = sc.next().toInt()
    val A = IntArray(M)
    for (i in 0 until M) {
        A[i] = sc.next().toInt()
    }
    solve(N, M, A)
}
