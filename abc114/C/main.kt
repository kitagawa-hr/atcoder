import java.io.*
import java.util.*

fun solve(N: Int) {
    val ans = (3..9).map { create753(it) }.flatten().distinct()
        .filter { it.toInt() <= N }
        .filter {
            "3" in it && "5" in it && "7" in it
        }.size
    println(ans)
}

fun create753(digit: Int): List<String> {
    var lis = listOf("3", "5", "7")
    repeat(digit - 1) {
        lis = lis.flatMap { listOf(it + "3", it + "5", it + "7") }
    }
    return lis
}

fun powerOfTen(x: Int): Int {
    var n = x
    var count = 0
    while (n > 0) {
        n /= 10
        count++
    }
    return count
}

tailrec fun Int.pow(n: Int): Int = if (n <= 1) this else this * this.pow(n - 1)

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
