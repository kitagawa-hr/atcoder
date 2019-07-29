import java.io.*
import java.util.*

fun solve(N: Int, S: String) {
    val westSum = S.map { if (it == 'W') 1 else 0 }.scanLeft(0) { a, b -> a + b }.toList()
    val eastSum = S.map { if (it == 'E') 1 else 0 }.scanLeft(0) { a, b -> a + b }.toList()
    val ans = (0 until N)
        .map { westSum.getOrElse(it - 1) { 0 } + eastSum[N - 1] - eastSum.getOrElse(it) { 0 } }
        .min()
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
    val S = sc.next()
    solve(N, S)
}
