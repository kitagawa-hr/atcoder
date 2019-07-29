import java.io.*
import java.util.*

fun solve(D: Int, G: Int, p: IntArray, c: IntArray) {
    // 中途半端に解くのは一種類以下で、完答してない中で一番高い点数のもの
    // 完答リスト
    val combs = (0 until D).toSet().powerSet()
    val candidates = mutableListOf<Int>()
    for (comb in combs) {
        val point = comb.map { p[it] * (it + 1)* 100 + c[it] }.sum()
        val quant = comb.map { p[it] }.sum()
        if (point >= G) candidates.add(quant)
        else {
            val m = (0 until D).toList().filter { it !in comb }.max() ?: continue
            val ret = divCeil(G - point, 100 * (m + 1))
            if (ret < p[m] ) candidates.add(quant + ret)
        }
    }
    println(candidates.min())
    return
}

fun divCeil(a: Int, b: Int) = a / b + if (a % b == 0) 0 else 1

fun <T> Collection<T>.powerSet(): Set<Set<T>> = powerSet(this, setOf(setOf()))

private tailrec fun <T> powerSet(left: Collection<T>, acc: Set<Set<T>>): Set<Set<T>> = when {
    left.isEmpty() -> acc
    else -> powerSet(left.drop(1), acc + acc.map { it + left.first() })
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
    val D = sc.next().toInt()
    val G = sc.next().toInt()
    val p = IntArray(D)
    val c = IntArray(D)
    for (i in 0 until D) {
        p[i] = sc.next().toInt()
        c[i] = sc.next().toInt()
    }
    solve(D, G, p, c)
}
