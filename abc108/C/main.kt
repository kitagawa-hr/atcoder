import java.io.*
import java.util.*

fun solve(N: Int, K: Int) {
    val a = (1..N).filter { (2 * it) % K == 0 && it % K != 0 }.size.toLong()
    val b = if (N >= K) N / K else 0
    println(cubic(a) + cubic(b.toLong()))
    return
}

fun cubic(x: Long) = x * x * x


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
    val K = sc.next().toInt()
    solve(N, K)
}

