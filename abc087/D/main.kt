import java.io.*
import java.util.*

var pw = PrintWriter(System.out)
const val YES = "Yes"
const val NO = "No"
fun solve(N: Long, M: Long, L: LongArray, R: LongArray, D: LongArray){
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
    val L = LongArray(M.toInt())
    val R = LongArray(M.toInt())
    val D = LongArray(M.toInt())
    for (i in 0 until M.toInt()) {
        L[i] = sc.next().toLong()
        R[i] = sc.next().toLong()
        D[i] = sc.next().toLong()
    }
    solve(N, M, L, R, D)
}

