import java.io.*
import java.util.*

var pw = PrintWriter(System.out)
const val MOD = 1000000007
fun solve(N: Long, K: Long, a: LongArray, b: LongArray) {
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
    val K = sc.next().toLong()
    val a = LongArray((N - 1).toInt())
    val b = LongArray((N - 1).toInt())
    for (i in 0 until (N - 1).toInt()) {
        a[i] = sc.next().toLong()
        b[i] = sc.next().toLong()
    }
    solve(N, K, a, b)
}
