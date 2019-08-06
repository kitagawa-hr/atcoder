import java.io.*
import java.util.*

fun solve(N: Int, M: Int) {
    // Mの約数のうち、M/Nよりも小さいものが候補となる
    // M = d * m
    var ret = M / N
    while (M % ret != 0) {
        ret--
    }
    println(ret)
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
    val M = sc.next().toInt()
    solve(N, M)
}
