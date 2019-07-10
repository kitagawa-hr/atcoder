import java.io.*
import java.util.*

var pw = PrintWriter(System.out)

class UnionFind(n: Int) {
    data class Node(var parent: Int, var size: Int)
    val nodes = Array<Node>(n) { Node(parent = it, size = 1) }
    fun findRoot(x: Int): Int {
        if (x == nodes[x].parent) return x
        nodes[x].parent = findRoot(nodes[x].parent)
        return nodes[x].parent
    }
    fun unite(x: Int, y: Int) {
        var xRoot = findRoot(x)
        var yRoot = findRoot(y)
        if (xRoot == yRoot) return
        if (getSize(xRoot) < getSize(yRoot)) {
            nodes[xRoot].parent = yRoot
            nodes[yRoot].size += nodes[xRoot].size
        } else {
            nodes[yRoot].parent = xRoot
            nodes[xRoot].size += nodes[yRoot].size
        }
    }
    fun getSize(x: Int) = nodes[findRoot(x)].size
    fun isSame(x: Int, y: Int) = findRoot(x) == findRoot(y)
}

fun solve(N: Int, M: Int, A: IntArray, B: IntArray) {
    val uf = UnionFind(N)
    val dp = LongArray(M)
    val n = N.toLong()
    dp[M - 1] = (n * (n - 1) / 2).toLong()
    for (i in M - 2 downTo 0) {
        var node1 = A[i + 1] - 1
        var node2 = B[i + 1] - 1
        if (uf.isSame(node1, node2)){
            dp[i] = dp[i+1]
        }
        else{
            var N1 = uf.getSize(node1).toLong()
            var N2 = uf.getSize(node2).toLong()
            dp[i] = dp[i+1] - N1 * N2
            uf.unite(node1, node2)
        }
    }
    dp.forEach{ pw.println(it) }
    pw.flush()
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
    val A = IntArray(M)
    val B = IntArray(M)
    for (i in 0 until M) {
        A[i] = sc.next().toInt()
        B[i] = sc.next().toInt()
    }
    solve(N, M, A, B)
}
