import java.io.*
import java.util.*

val pw = PrintWriter(System.out)
fun solve(N: Int, A: IntArray){
    // [3, 5, -1, 0] -> [3, 5, 11, 12]
    val cumSum = (0..N)
        .map{ Math.abs(A.getOrElse(it){ 0 } - A.getOrElse(it - 1){ 0 }) }
        .scanLeft(0){ a, b -> a + b }
        .toList()
        .last()!!
    repeat(N){
        val a = A.getOrElse(it - 1){ 0 }
        val b = A[it]
        val c = A.getOrElse(it + 1){ 0 }
        val (m, M) = Math.min(a,c) to Math.max(a, c)
        if (b < m) pw.println(cumSum - 2 * Math.abs(b-m))
        else if (b < M) pw.println(cumSum)
        else  pw.println(cumSum - 2 * Math.abs(b-M))
    }
    pw.flush()
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
    val A = IntArray(N)
    for (i in 0 until N) {
        A[i] = sc.next().toInt()
    }
    solve(N, A)
}

