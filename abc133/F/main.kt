import java.io.*
import java.util.*

var pw = PrintWriter(System.out)
fun solve(
    N: Long,
    Q: Long,
    a: LongArray,
    b: LongArray,
    c: LongArray,
    d: LongArray,
    x: LongArray,
    y: LongArray,
    u: LongArray,
    v: LongArray
) {
    pw.flush()
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
    val N = sc.next().toLong()
    val Q = sc.next().toLong()
    val a = LongArray((N - 1).toInt())
    val b = LongArray((N - 1).toInt())
    val c = LongArray((N - 1).toInt())
    val d = LongArray((N - 1).toInt())
    for (i in 0 until (N - 1).toInt()) {
        a[i] = sc.next().toLong()
        b[i] = sc.next().toLong()
        c[i] = sc.next().toLong()
        d[i] = sc.next().toLong()
    }
    val x = LongArray(Q.toInt())
    val y = LongArray(Q.toInt())
    val u = LongArray(Q.toInt())
    val v = LongArray(Q.toInt())
    for (i in 0 until Q.toInt()) {
        x[i] = sc.next().toLong()
        y[i] = sc.next().toLong()
        u[i] = sc.next().toLong()
        v[i] = sc.next().toLong()
    }
    solve(N, Q, a, b, c, d, x, y, u, v)
}
