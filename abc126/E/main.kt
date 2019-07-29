import java.io.*
import java.util.*

fun solve(N: Int, M: Int, X: IntArray, Y: IntArray, Z: IntArray) {
    val uf = UnionFind(N + 1)
    repeat(M) {
        uf.unite(X[it], Y[it])
    }
    var nodes = (1..N).toList()
    var ans = (1..N).toList().map { uf.findRoot(it) }.distinct().size
    println(ans)
    return
}
class UnionFind(n: Int) {
    data class Node(var parent: Int, var size: Int)
    val nodes = Array<Node>(n) { Node(parent = it, size = 1) }
    fun findRoot(x: Int): Int {
        if (x == this.nodes[x].parent) return x
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
    val Y = IntArray(M)
    val Z = IntArray(M)
    for (i in 0 until M.toInt()) {
        X[i] = sc.next().toInt()
        Y[i] = sc.next().toInt()
        Z[i] = sc.next().toInt()
    }
    solve(N, M, X, Y, Z)
}
