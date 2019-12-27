import java.io.*
import java.util.*

fun solve(N: Int, M: Int, a: IntArray, b: IntArray){
    val graph = AdjacencyMatrixGraph<Int, Int>(Array(N){ arrayOfNulls<Int>(N) })
    fun isConnected(removedEdge: Set<Int>): Boolean{
        val deque = ArrayDeque<Int>()
        val visited = BooleanArray(N){ false }
        deque.add(0)
        while(deque.size > 0){
            val node = deque.removeFirst()
            if (visited[node]) continue
            visited[node] = true
            graph.edgesFrom(node).forEach{
                if (!(removedEdge == setOf(node, it.to))) deque.add(it.to)
            }
        }
        return visited.all{ it }
    }
    for(i in 0 until M){
        graph.addEdge(a[i]-1, b[i]-1, 1)
        graph.addEdge(b[i]-1, a[i]-1, 1)
    }
    var ans = 0
    for (i in 0 until M){
        val removedEdge = setOf(a[i] - 1, b[i] - 1)
        if (!(isConnected(removedEdge))) ans++
    }
    println(ans)
    return
}


interface Graph<T : Comparable<T>, E : Comparable<E>> {
    val size: Int
    fun getWeight(from: Int, to: Int): E?
    fun edgesFrom(from: Int): List<Edge<E>>
    fun addEdge(from: Int, to: Int, weight: E): Boolean
    fun removeEdge(from: Int, to: Int): Boolean
    fun isAdjacent(from: Int, to: Int): Boolean
}

data class Edge<T : Comparable<T>>(val to: Int, val weight: T)
data class Vertex<T : Comparable<T>, E : Comparable<E>>(val data: T) {
    val edges = mutableListOf<Edge<E>>()

    fun addEdge(to: Int, weight: E) = when (edges.find { it.to == to }) {
        null -> {
            edges.add(Edge(to, weight))
            true
        }
        else -> false
    }

    fun removeEdge(to: Int): Boolean {
        for ((i, edge) in edges.withIndex()) {
            if (edge.to == to) {
                edges.removeAt(i)
                return true
            }
        }
        return false
    }
}

class AdjacentListGraph<T : Comparable<T>, E : Comparable<E>>(
    private val vertices: MutableList<Vertex<T, E>>
) : Graph<T, E> {
    override val size = vertices.size
    override fun getWeight(from: Int, to: Int): E? =
        vertices[from].edges.find { it.to == to }?.weight
    override fun edgesFrom(from: Int): List<Edge<E>> = vertices[from].edges
    override fun addEdge(from: Int, to: Int, weight: E) = vertices[from].addEdge(to, weight)
    override fun removeEdge(from: Int, to: Int) = vertices[from].removeEdge(to)
    override fun isAdjacent(from: Int, to: Int) =
        vertices[from].edges.find { it.to == to } != null
}

class AdjacencyMatrixGraph<T : Comparable<T>, E : Comparable<E>>(
    private val matrix: Array<Array<E?>>
) : Graph<T, E> {
    override val size = matrix.size
    override fun getWeight(from: Int, to: Int): E? = matrix[from][to]
    override fun edgesFrom(from: Int): List<Edge<E>> =
        matrix[from].withIndex()
            .filter { it.value != null }
            .map { Edge(it.index, it.value!!) }

    override fun addEdge(from: Int, to: Int, weight: E): Boolean {
        if (matrix[from][to] == null) {
            matrix[from][to] = weight
            return true
        }
        return false
    }

    override fun removeEdge(from: Int, to: Int): Boolean {
        if (from >= size || to >= size || matrix[from][to] == null) {
            return false
        }
        matrix[from][to] = null
        return true
    }

    override fun isAdjacent(from: Int, to: Int): Boolean = matrix[from][to] != null
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
    val a = IntArray(M)
    val b = IntArray(M)
    for (i in 0 until M) {
        a[i] = sc.next().toInt()
        b[i] = sc.next().toInt()
    }
    solve(N, M, a, b)
}

