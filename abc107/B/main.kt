import java.io.*
import java.util.*

val pw = PrintWriter(System.out)


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

    val (H, W) = readLine()!!.split(' ').map { it.toInt() }
    var a = Array<String>(H) { readLine()!! }.filter { it.count { chr -> chr == '.' } != W }
    val lis = mutableListOf<Int>()
    for (i in 0 until a[0].length) {
        if (a.map { it[i] == '.' }.all { it == true }) {
            lis.add(i)
        }
    }
    a = a.map { it.filterIndexed { idx, value -> idx !in lis } }
    a.forEach { println(it) }
}

