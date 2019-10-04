import java.io.*
import java.util.*

val pw = PrintWriter(System.out)
fun solve(N: Long, h: LongArray, a: LongArray) {
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
    val h = LongArray(N.toInt())
    for (i in 0 until N.toInt()) {
        h[i] = sc.next().toLong()
    }
    val a = LongArray(N.toInt())
    for (i in 0 until N.toInt()) {
        a[i] = sc.next().toLong()
    }
    solve(N, h, a)
}
