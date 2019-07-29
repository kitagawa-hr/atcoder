import java.io.*
import java.util.*

fun solve(N: Long, A: LongArray){
    val n = N.toInt()
    val cumSum = A.scanLeft(0){ a,b -> a + b }.toList()
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
    val N = sc.next().toLong()
    val A = LongArray(N.toInt())
    for (i in 0 until N.toInt()) {
        A[i] = sc.next().toLong()
    }
    solve(N, A)
}