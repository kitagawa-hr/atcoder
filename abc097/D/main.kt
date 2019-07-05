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

fun solve(N: Int, M: Int, p: IntArray, x: IntArray, y: IntArray){
    val uf = UnionFind(N)
    repeat(M){
        uf.unite(x[it]-1, y[it]-1)
    }
    var ans = 0
    for ( i in 0 until N ){
        if ( uf.isSame(i, p[i] - 1) ){ ans++ }
    }
    pw.println(ans)
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
    val p = IntArray(N)
    for (i in 0 until N) {
        p[i] = sc.next().toInt()
    }
    val x = IntArray(M)
    val y = IntArray(M)
    for (i in 0 until M) {
        x[i] = sc.next().toInt()
        y[i] = sc.next().toInt()
    }
    solve(N, M, p, x, y)
}

