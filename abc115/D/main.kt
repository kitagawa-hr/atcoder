import java.io.*
import java.util.*

fun solve(N: Int, X: Long) {
    val sizes = LongArray(51)
    val patties = LongArray(51)
    sizes[0] = 1
    patties[0] = 1
    for (i in 1..N) {
        sizes[i] = 2 * sizes[i - 1] + 3
        patties[i] = 2 * patties[i - 1] + 1
    }
    fun pattyAmount(n: Int, x: Long): Long {
        if (x == 0L) return 0L
        if (n == 0) return 1L
        if (x == 1L) return 0L
        if (x >= sizes[n]) return patties[n]
        if (x >= (sizes[n] + 1) / 2) {
            return (patties[n] + 1) / 2 + pattyAmount(n, x - (sizes[n] + 1) / 2 + 1)
        }
        return pattyAmount(n - 1, x - 1)
    }
    println(pattyAmount(N, X))
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
    val X = sc.next().toLong()
    solve(N, X)
}
