import java.io.*
import java.util.*

fun solve(N: Int, a: LongArray) {
    // 隣合う和が最小のペアを選び合体させるのが最適
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
    val N = sc.next().toLong()
    val a = LongArray(N)
    for (i in 0 until N) {
        a[i] = sc.next().toLong()
    }
    solve(N, a)
}
