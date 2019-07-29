import java.io.*
import java.util.*

const val MOD = 1000000007
fun solve(S: String) {
    val n = S.length
    // dp[mod][i] = 左からi桁まで見て、あまりがmodであるものの数
    val dp = Array(13) { LongArray(n + 1) }
    dp[0][0] = 1L
    for (i in 1..n) {
        for (mod in 0..12) {
            val digits = when (S[i - 1]) {
                '?' -> (0..9).asSequence()
                else -> sequenceOf(S[i - 1].toNum())
            }
            for (digit in digits) {
                val nextMod = (mod * 10 + digit).floorMod(13).toInt()
                dp[nextMod][i] += dp[mod][i - 1]
                dp[nextMod][i] = dp[nextMod][i] % MOD
            }
        }
    }
    // println(dp.contentDeepToString())
    println(dp[5][n])
    return
}

fun Int.floorMod(mod: Int): Int{
    val ret = this % mod
    return if (ret >= 0) ret else ret+mod
}

fun Char.toNum(): Int = when(this){
    '0' -> 0
    '1' -> 1
    '2' -> 2
    '3' -> 3
    '4' -> 4
    '5' -> 5
    '6' -> 6
    '7' -> 7
    '8' -> 8
    '9' -> 9
    else -> -1
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
