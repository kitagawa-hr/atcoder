import java.io.*
import java.util.*

const val MOD = 1000000007
fun solve(N: Int, K: Int) {
    // dp[i][j][k] = 1 ~ iまで用いたとき、残りjペアであり、奇妙さkになる場合の数
    val dp = Array(51){ Array(51){ LongArray(2501) } }
    for (i in 1..50){
        for(j in 1..50){
            for(k in 2*j..2500)
                dp[i][j][k] = dp[i-1][j][k-2*j] + (j+1)*(j+1)*dp[i-1][j+1][k-2*j] + dp[i-1][j-1][k-2*j]
        }
    }
    println(dp[N][0][K])
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
    val n = sc.next().toInt()
    val k = sc.next().toInt()
    solve(n, k)
}
