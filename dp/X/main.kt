import java.io.*
import java.util.*

val pw = PrintWriter(System.out)
fun solve(N: Long, w: LongArray, s: LongArray, v: LongArray) {
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
    val w = LongArray(N.toInt())
    val s = LongArray(N.toInt())
    val v = LongArray(N.toInt())
    for (i in 0 until N.toInt()) {
        w[i] = sc.next().toLong()
        s[i] = sc.next().toLong()
        v[i] = sc.next().toLong()
    }
    solve(N, w, s, v)
}
