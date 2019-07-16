import java.io.*
import java.util.*

val pw = PrintWriter(System.out)
fun solve(D: Long) {
    when (D) {
        25L -> { println("Christmas") }
        24L -> { println("Christmas Eve") }
        23L -> { println("Christmas Eve Eve") }
        22L -> { println("Christmas Eve Eve Eve") }
        else -> { println("null") }
    }
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
    val D = sc.next().toLong()
    solve(D)
}
