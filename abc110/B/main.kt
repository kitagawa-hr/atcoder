import java.io.*
import java.util.*

val pw = PrintWriter(System.out)
fun solve(N: Int, M: Int, X: Int, Y: Int, x: IntArray, y: IntArray) {
    for (z in X + 1..Y) {
        if (z> x.max()!! && z <= y.min()!!) {
            println("No War")
            return
        }
    }
    println("War")
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
    val X = sc.next().toInt()
    val Y = sc.next().toInt()
    val x = IntArray(N)
    for (i in 0 until N) {
        x[i] = sc.next().toInt()
    }
    val y = IntArray(M)
    for (i in 0 until M) {
        y[i] = sc.next().toInt()
    }
    solve(N, M, X, Y, x, y)
}
