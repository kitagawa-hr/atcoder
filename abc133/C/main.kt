import java.io.*
import java.util.*

var pw = PrintWriter(System.out)
const val MOD = 2019
fun solve(L: Int, R: Int) {
    var ans = 2019 * 2019
    val range = when {
        R - L >= 2019 -> IntArray(2019) { it }.toList()
        else -> (L..R).toList().map { it % 2019 }
    }
    // println(range.toString())
    for (i in 0 until range.size) {
        for (j in i + 1 until range.size) {
            ans = Math.min(ans, (range[i] * range[j]) % 2019)
        }
    }
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
    val L = sc.next().toInt()
    val R = sc.next().toInt()
    solve(L, R)
}
