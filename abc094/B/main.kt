import java.io.*
import java.util.*

fun solve(N: Long, M: Long, X: Long, A: LongArray) {
    val a = A.count { it > X }
    println(Math.min(a, M.toInt() - a))
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
    val X = sc.next().toLong()
    val A = LongArray(M.toInt())
    for (i in 0 until M.toInt()) {
        A[i] = sc.next().toLong()
    }
    solve(N, M, X, A)
}
