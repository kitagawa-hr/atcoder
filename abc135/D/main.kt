import java.io.*
import java.util.*

const val MOD = 1000000007
fun solve(S: String){
    val n =S.length
    val dp = Array(13){LongArray(n+1)}
    dp[0][0] = 1
    for (i in 1..n){
        for (j in 0..12){
            val digits = if (S[i-1] == '?') (0..9).toList() else listOf(S[i-1].toInt())
            for (digit in digits){
                val m = (dp[j][i-1]*10 + digit) % 13
                dp[m.toInt()][i] += dp[j][i-1]
            }
        }
    }
    println(dp[5][n])
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
    val S = sc.next()
    solve(S)
}

