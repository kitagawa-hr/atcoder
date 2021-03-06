import java.io.*
import java.util.*

const val YES = "YES"
const val NO = "NO"
fun solve(A: Long, B: Long, X: Long) {
    if (A <= X && X <= A + B) {
        println(YES)
    } else println(NO)
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
    val A = sc.next().toLong()
    val B = sc.next().toLong()
    val X = sc.next().toLong()
    solve(A, B, X)
}
