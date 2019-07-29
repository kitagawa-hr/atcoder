import java.io.*
import java.util.*


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
    val (x1, y1, x2, y2) = readLine()!!.split(' ').map { it.toInt() }
    val (a, b) = Pair(x2 - x1, y2 - y1)
    val (x3, y3) = Pair(x2 - b, y2 + a)
    val (x4, y4) = Pair(x1 - b, y1 + a)
    println("$x3 $y3 $x4 $y4")
}

