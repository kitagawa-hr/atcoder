import java.io.*
import java.util.*

fun solve(N: Long){
    // dp[j] = j円作るのに必要な最小な操作数 = i
    // dp[j] = MIN(dp[j-yen]) yen <= j
    val n = N.toInt()
    val dp = LongArray(100001)
    val yens = listOf(1, 6, 36, 216, 1296, 7776, 46656, 9, 81, 729, 6561, 59049 ).sorted()
    for ( i in 1..n ){
        dp[i] = yens.filter{ it <= i }.map{ dp[i-it] + 1}.min()!!
        // println(dp[i])
    }
    println(dp[n])
    return
}

fun Int.pow(x: Double): Double = Math.pow(this.toDouble(), x)
fun Long.pow(x: Double): Double = Math.pow(this.toDouble(), x)


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
    val N = sc.next().toLong()
    solve(N)
}

