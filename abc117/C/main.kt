import java.io.*
import java.util.*

// コマの数, 座標の数
// all_vars ~ 10 ^ 5
fun solve(N: Int, M: Int, X: IntArray) {
    val x = X.sorted()
    if (N == 1) { println(x.last() - x.first()); return }
    if (N >= M) { println(0); return }
    val diff = mutableListOf<Int>()
    for (i in 1 until M) {
        diff.add(x[i] - x[i - 1])
    }
    diff.sortDescending()
    println(x.last() - x[0] - diff.slice(0 until N - 1).sum())
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
    val X = IntArray(M)
    for (i in 0 until M) {
        X[i] = sc.next().toInt()
    }
    solve(N, M, X)
}
