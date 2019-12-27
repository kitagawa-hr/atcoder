import java.io.*
import java.util.*

fun solve(N: Int, K: Int, x: LongArray, y: LongArray){
    var ans = Long.MAX_VALUE
    val xy = (0 until N).map{ x[it] to y[it] }.sortedBy{ it.first }
    for (i in 0 until N){
        for(j in i+1 until N){
            val ys = xy.filter{ xy[i].first <= it.first && it.first <= xy[j].first }.map{ it.second }.sorted()
            if(ys.size < K) continue
            val height = (0..ys.size - K).map{ ys[it + K - 1] - ys[it] }.min()!!
            ans = Math.min(ans, height * (xy[j].first - xy[i].first))
        }
    }
    println(ans)
    return
}

fun <T> Collection<T>.powerSet(): Set<Set<T>> = powerSet(this, setOf(setOf()))

private tailrec fun <T> powerSet(left: Collection<T>, acc: Set<Set<T>>): Set<Set<T>> = when {
    left.isEmpty() -> acc
    else -> powerSet(left.drop(1), acc + acc.map { it + left.first() })
}

fun <T> Set<T>.combinations(n: Int): Set<Set<T>> = when {
    n < 0 -> throw Error("n must be positive, but got $n")
    n == 0 -> setOf(setOf())
    n >= size -> setOf(toSet())
    else -> powerSet()
            .filter { it.size == n }
            .toSet()
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
    val K = sc.next().toInt()
    val x = LongArray(N)
    val y = LongArray(N)
    for (i in 0 until N) {
        x[i] = sc.next().toLong()
        y[i] = sc.next().toLong()
    }
    solve(N, K, x, y)
}

