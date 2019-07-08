import java.io.*
import java.util.*

var pw = PrintWriter(System.out)

fun isSquare(x: Int): Boolean {
    if (x == 1 || x == 0) {
        return true
    }
    for (i in 1..x) {
        if (x % i == 0 && i * i == x) {
            return true
        }
    }
    return false
}

fun solve(N: Int, D: Int, X: Array<IntArray>) {
    var ans = 0
    for (i in 0 until N) {
        for (j in i + 1 until N) {
            val dest = IntArray(D) { X[i][it] - X[j][it] }.map { it*it }.sum()
            if (isSquare(dest)) ans++
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
    val N = sc.next().toInt()
    val D = sc.next().toInt()
    val X = Array<IntArray>(N) { IntArray(D) }
    for (i in 0 until N) {
        for (j in 0 until D) {
            X[i][j] = sc.next().toInt()
        }
    }
    solve(N, D, X)
}
