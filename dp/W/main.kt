import java.io.*
import java.util.*

val pw = PrintWriter(System.out)
fun solve(N: Long, M: Long, l: LongArray, r: LongArray, a: LongArray) {
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
    val l = LongArray(M.toInt())
    val r = LongArray(M.toInt())
    val a = LongArray(M.toInt())
    for (i in 0 until M.toInt()) {
        l[i] = sc.next().toLong()
        r[i] = sc.next().toLong()
        a[i] = sc.next().toLong()
    }
    solve(N, M, l, r, a)
}
