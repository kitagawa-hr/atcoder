import java.io.*
import java.util.*

val pw = PrintWriter(System.out)
const val MOD = 1000000007
fun solve(H: Long, W: Long, N: Long, r: LongArray, c: LongArray) {
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
    val H = sc.next().toLong()
    val W = sc.next().toLong()
    val N = sc.next().toLong()
    val r = LongArray(N.toInt())
    val c = LongArray(N.toInt())
    for (i in 0 until N.toInt()) {
        r[i] = sc.next().toLong()
        c[i] = sc.next().toLong()
    }
    solve(H, W, N, r, c)
}
