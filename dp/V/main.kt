import java.io.*
import java.util.*

val pw = PrintWriter(System.out)
fun solve(N: Long, M: Long, x: LongArray, y: LongArray) {
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
    val M = sc.next().toLong()
    val x = LongArray((N - 1).toInt())
    val y = LongArray((N - 1).toInt())
    for (i in 0 until (N - 1).toInt()) {
        x[i] = sc.next().toLong()
        y[i] = sc.next().toLong()
    }
    solve(N, M, x, y)
}
