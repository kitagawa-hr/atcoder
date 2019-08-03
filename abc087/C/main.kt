import java.io.*
import java.util.*

var pw = PrintWriter(System.out)
fun solve(N: Long, A: Array<LongArray>){
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
    val A = Array<LongArray>(2.toInt()){ LongArray(N.toInt()) }
    for (i in 0 until 2.toInt()) {
        for (j in 0 until N.toInt()) {
            A[i][j] = sc.next().toLong()
        }
    }
    solve(N, A)
}

