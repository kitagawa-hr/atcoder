import java.io.*
import java.util.*

const val MOD = 1000000007L
// K個の飴をN人で分け合う方法の数
// 各飴の数はai以下
// N~100, K~1e5

fun <T, R> Iterable<T>.scanLeft(initial: R, operation: (acc: R, T) -> R): Sequence<R> {
    var last = initial
    return this.asSequence().map { last = operation(last, it); last }
}

fun solve(N: Int, K: Int, a: IntArray) {
    // dp[i][j] i番目まででj個を分ける方法の数
    // dp[i][j] = sum(dp[i-1][j-k]){k=0~a[i]}
    val dp = Array(N + 1) { LongArray(K + 1) }
    val cumSum = Array(N + 1) { LongArray(K + 1) }
    dp[0][0] = 1L
    for (x in 0..K) cumSum[0][x] = 1L
    for (i in 1..N) {
        for (j in 0..K) {
            dp[i][j] = (cumSum[i - 1][j] - cumSum[i - 1].getOrElse(j - a[i-1] - 1) { 0L }) % MOD
            cumSum[i][j] = cumSum[i].getOrElse(j-1){ 0L } + dp[i][j]
        }
    }
    println(dp[N][K])
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
    val K = sc.next().toInt()
    val a = IntArray(N)
    for (i in 0 until N) {
        a[i] = sc.next().toInt()
    }
    solve(N, K, a)
}
