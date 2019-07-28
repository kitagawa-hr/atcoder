import java.io.*
import java.util.*

const val MOD = 1000000007L

fun amida(n: Int): Long = when {
    n <= 1 -> 1L
    n == 2 -> 2L
    else -> amida(n - 1) + amida(n - 2)
}

fun solve(H: Int, W: Int, K: Int) {
    // dp[w][h] = 高さhでwにたどり着くあみだくじの総数
    val dp = Array<LongArray>(W + 1) { LongArray(H + 1) }
    dp[0][0] = 1
    for (h in 1..H) {
        for (w in 0 until W) {
            dp[w][h] = when (w) {
                0 -> 0 + amida(W - 1) * dp[w][h - 1] % MOD + amida(W - 2) * dp[w + 1][h - 1] % MOD
                W - 1 -> amida(W - 2) * dp[w - 1][h - 1] % MOD + amida(W - 1) * dp[w][h - 1] % MOD + 0
                else ->
                    (
                        amida(w-1) * amida(W - w - 1) * dp[w - 1][h - 1] % MOD +
                            amida(w) * amida(W - w - 1) * dp[w][h - 1] % MOD +
                            amida(w) * amida(W - w - 2) * dp[w + 1][h - 1] % MOD
                        )
            }
            dp[w][h] %= MOD
        }
    }
    println(dp[K - 1][H])
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
    val H = sc.next().toInt()
    val W = sc.next().toInt()
    val K = sc.next().toInt()
    solve(H, W, K)
}
