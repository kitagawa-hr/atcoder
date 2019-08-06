import java.io.*
import java.util.*

var pw = PrintWriter(System.out)
fun solve(N: Int, M: Long, A: LongArray) {
    // cumSum[i]のMで割った余りについて、それぞれの個数を求める
    val cumSum = A.toList().scanLeft(0L) { a, b -> a + b }.toList()
    val pairs = cumSum.map { it % M }
        .groupBy { it }.map { it.key to it.value.size.toLong() }
    val ans = pairs
        .map { (it.second * (it.second - 1)) / 2 + if (it.first == 0L) it.second else 0L }
        .sum()
    println(ans)
    return
}

fun <T, R> Iterable<T>.scanLeft(initial: R, operation: (acc: R, T) -> R): Sequence<R> {
    var last = initial
    return this.asSequence().map { last = operation(last, it); last }
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
    val M = sc.next().toLong()
    val A = LongArray(N)
    for (i in 0 until N) {
        A[i] = sc.next().toLong()
    }
    solve(N, M, A)
}
