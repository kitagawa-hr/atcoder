import java.io.*
import java.util.*

// edge = xi -> yi
// 有向グラフの直径(最大のパス)
fun solve(N: Int, M: Int, x: IntArray, y: IntArray) {
    val edges = Array(N){ ArrayDeque<Int>() }
    // val revEdges = Array(N){ ArrayDeque<Int>() }
    for (i in 0 until M){
        edges[x[i] - 1].addLast(y[i]-1)
    }
    // dp[i] = longest path length of subtree of which root is i
    val dp = IntArray(N)
    for (i in ){
        dp[i] = 1 + (edges[i]).map{ dp[it] }.max()?: 0
    }
    println(dp.max()?: 0)
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
    val x = IntArray(M)
    val y = IntArray(M)
    for (i in 0 until M) {
        x[i] = sc.next().toInt()
        y[i] = sc.next().toInt()
    }
    solve(N, M, x, y)
}
