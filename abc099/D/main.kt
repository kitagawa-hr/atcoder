import java.io.*
import java.util.*

var pw = PrintWriter(System.out)
fun solve(N: Long, C: Long, D: Array<LongArray>, c: Array<LongArray>){
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
    val C = sc.next().toLong()
    val D = Array<LongArray>(C.toInt()){ LongArray(C.toInt()) }
    for (i in 0 until C.toInt()) {
        for (j in 0 until C.toInt()) {
            D[i][j] = sc.next().toLong()
        }
    }
    val c = Array<LongArray>(N.toInt()){ LongArray(N.toInt()) }
    for (i in 0 until N.toInt()) {
        for (j in 0 until N.toInt()) {
            c[i][j] = sc.next().toLong()
        }
    }
    solve(N, C, D, c)
}

