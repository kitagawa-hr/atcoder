import java.io.*
import java.util.*

fun solve(N: Int, T: Int, A: Int, H: IntArray) {
    println(H.map { Math.abs(T - 0.006 * it - A) }.withIndex().minBy { it.value }!!.index + 1)
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
    val T = sc.next().toInt()
    val A = sc.next().toInt()
    val H = IntArray(N)
    for (i in 0 until N) {
        H[i] = sc.next().toInt()
    }
    solve(N, T, A, H)
}
