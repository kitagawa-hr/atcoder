import java.io.*
import java.util.*

fun solve(a: Long, b: Long) {
    val ans = a - 1 + if (b >= a) 1 else 0
    println(ans)
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
    val a = sc.next().toLong()
    val b = sc.next().toLong()
    solve(a, b)
}
