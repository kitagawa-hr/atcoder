import java.io.*
import java.util.*

fun solve(R: Long) {
    when {
        R < 1200L -> { println("ABC") }
        R < 2800L -> { println("ARC") }
        else -> { println("AGC") }
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
    val R = sc.next().toLong()
    solve(R)
}
