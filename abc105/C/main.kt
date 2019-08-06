import java.io.*
import java.util.*

fun solve(N: Int) {
    if (N == 0) { println(0); return }
    var n = N.toLong()
    val ans = ArrayDeque<Int>()
    var ret = -2L
    for (i in 0 until 32) {
        if (n % ret == 0L) {
            ans.addFirst(0)
        } else {
            ans.addFirst(1)
            n -= -ret / 2
        }
        ret *= -2
    }
    println(ans.dropWhile { it == 0 }.joinToString(separator = ""))
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
    val N = sc.next().toInt()
    solve(N)
}
