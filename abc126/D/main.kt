import java.io.*
import java.util.*

val pw = PrintWriter(System.out)

fun solve(N: Int, u: IntArray, v: IntArray, w: IntArray) {
    val uf = WeightedUnionFind(N)
    repeat(N - 1) {
        uf.unite(u[it] - 1, v[it] - 1, w[it].toLong())
    }
    pw.println(1)
    for (i in 1 until N) {
        if (uf.getDiff(0, i) % 2L == 0L) {
            pw.println(1)
        } else {
            pw.println(0)
        }
    }
    pw.flush()
    return
}


class WeightedUnionFind(n: Int) {
    data class Node(var parent: Int, var size: Int, var weightDiff: Long)

    private val nodes = Array(n) { Node(parent = it, size = 1, weightDiff = 0) }
    fun findRoot(x: Int): Int {
        if (x == this.nodes[x].parent) return x
        val root = findRoot(nodes[x].parent)
        nodes[x].weightDiff += nodes[nodes[x].parent].weightDiff
        nodes[x].parent = root
        return root
    }

    fun unite(x: Int, y: Int, weight: Long): Boolean {
        val xRoot = findRoot(x)
        val yRoot = findRoot(y)
        if (xRoot == yRoot) return false
        val (smaller, bigger) = if (getSize(xRoot) < getSize(yRoot)) {
            Pair(xRoot, yRoot)
        } else {
            Pair(yRoot, xRoot)
        }
        val newWeight = weight + getWeight(xRoot) - getWeight(yRoot)
        nodes[smaller].parent = bigger
        nodes[bigger].size += nodes[smaller].size
        nodes[smaller].weightDiff = if (smaller == xRoot) -newWeight else newWeight
        return true
    }

    fun getWeight(x: Int): Long {
        findRoot(x)
        return nodes[x].weightDiff
    }

    fun getDiff(x: Int, y: Int) = getWeight(y) - getWeight(x)
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
    val u = IntArray(N - 1)
    val v = IntArray(N - 1)
    val w = IntArray(N - 1)
    for (i in 0 until N - 1) {
        u[i] = sc.next().toInt()
        v[i] = sc.next().toInt()
        w[i] = (sc.next().toLong() % 2L).toInt()
    }
    solve(N, u, v, w)
}
