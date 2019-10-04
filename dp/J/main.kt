import java.io.*
import java.util.*

fun solve(N: Int, a: IntArray) {
    // E =
    // dp[i][j][k] = 1,2,3個の皿がi,j,k枚あるときの期待値 i+2j+3k <= N
    val ONE = a.count { it == 1 }
    val TWO = a.count { it == 2 }
    val THREE = a.count { it == 3 }
    val NUM = ONE + 2 * TWO + 3 * THREE
    val dp = Array(NUM + 1) { Array(NUM + 1) { DoubleArray(NUM + 1) } }
    // i+2*j+3*k = l
    for (l in 0 until NUM) {
        for (k in 0 until NUM) {
            for (j in 0 until NUM) {
                val i = l - 2 * j - 3 * k
                if (i < 0) continue
                if (i == 1 && j == 0 && k == 0) dp[i][j][k] = N.toDouble()
                if (i > 0)dp[i][j][k] += i * dp[i - 1][j][k]
                if (j > 0)dp[i][j][k] += j * dp[i + 1][j - 1][k]
                if (k > 0)dp[i][j][k] += k * dp[i][j + 1][k - 1]
                dp[i][j][k] = dp[i][j][k] / 3
            }
        }
    }
    for (i in 0 until N) {
        for (j in 0 until N) {
            for (k in 0 until N) {
                print(dp[i][j][k])
            }
        }
        println()
    }

    println(dp[ONE][TWO][THREE])
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
