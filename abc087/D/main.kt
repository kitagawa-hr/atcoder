import java.io.*
import java.util.*

val pw = PrintWriter(System.out)
const val YES = "Yes"
const val NO = "No"
fun solve(N: Int, M: Int, L: IntArray, R: IntArray, D: IntArray){
    val uf = WeightedUnionFind(N)
    val l = L.map{ it-1 }
    val r = R.map{ it-1 }
    val d = D.map{ it.toLong() }

    repeat(M){
        if ( uf.isSame(l[it], r[it]) && uf.getDiff(l[it], r[it]) != d[it] ) {
            println(NO)
            return
        }
        uf.unite(l[it], r[it], d[it])
    }
    println(YES)
    return
}

class WeightedUnionFind(n: Int) {
    data class Node(var parent: Int, var size: Int, var weight: Long)

    private val nodes = Array(n) { Node(parent = it, size = 1, weight = 0) }
    fun findRoot(x: Int): Int {
        if (x == this.nodes[x].parent) return x
        val root = findRoot(nodes[x].parent)
        nodes[x].weight += nodes[nodes[x].parent].weight
        nodes[x].parent = root
        return root
    }

    fun unite(x: Int, y: Int, weight: Long): Boolean {
        // nodes[x].weight + weight = nodes[y].weightとなるようにする
        val xRoot = findRoot(x)
        val yRoot = findRoot(y)
        if (xRoot == yRoot) return false
        val (smaller, bigger, newWeight) = when (getSize(xRoot) >= getSize(yRoot)) {
            true -> Triple(yRoot, xRoot, nodes[x].weight - nodes[y].weight + weight)
            else -> Triple(xRoot, yRoot, nodes[y].weight - nodes[x].weight - weight)
        }
        nodes[smaller].parent = bigger
        nodes[bigger].size += nodes[smaller].size
        nodes[smaller].weight = newWeight
        return true
    }

    fun getWeight(x: Int): Long {
        findRoot(x)
        return nodes[x].weight
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
    val M = sc.next().toInt()
    val L = IntArray(M)
    val R = IntArray(M)
    val D = IntArray(M)
    for (i in 0 until M) {
        L[i] = sc.next().toInt()
        R[i] = sc.next().toInt()
        D[i] = sc.next().toInt()
    }
    solve(N, M, L, R, D)
}

