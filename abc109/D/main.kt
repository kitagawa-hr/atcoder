import java.io.*
import java.util.*

val pw = PrintWriter(System.out)
fun solve(H: Int, W: Int, a: Array<IntArray>){
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
    val H = sc.next().toInt()
    val W = sc.next().toInt()
    val a = Array<IntArray>(H){ IntArray(W) }
    for (i in 0 until H) {
        for (j in 0 until W) {
            a[i][j] = sc.next().toInt()
        }
    }
    solve(H, W, a)
}

