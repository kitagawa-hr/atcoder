import java.io.*
import java.util.*

fun solve(n: Int, a: IntArray) {
    // dp[i] -> aから小さい順のi個を用いたときの最大ペア (bi, ci) bi < ci
    // dp[i] =
    val A = a.sorted().toList()
    val M = A.last()!!
    val half = M.toDouble() / 2
    val i = A.slice(0 until n-1)
        .map{ Math.abs(it.toDouble() - half) }
        .withIndex()
        .minBy{ it.value }!!
        .index
    println("$M ${A[i]}")
    return
}



fun <T : Comparable<T>> List<T?>.lowerBound(
        element: T,
        fromIndex: Int = 0,
        toIndex: Int = size
): Int {
    var low = fromIndex
    var high = toIndex
    while (low < high) {
        val mid = (low + high) / 2
        if (element <= this.get(mid)!!) {
            high = mid
        } else {
            low = mid + 1
        }
    }
    return low
}

fun <T : Comparable<T>> List<T?>.upperBound(
        element: T,
        fromIndex: Int = 0,
        toIndex: Int = size
): Int {
    var low = fromIndex
    var high = toIndex
    while (low < high) {
        val mid = (low + high) / 2
        if (element >= this.get(mid)!!) {
            low = mid + 1
        } else {
            high = mid
        }
    }
    return low
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
    val n = sc.next().toInt()
    val a = IntArray(n)
    for (i in 0 until n) {
        a[i] = sc.next().toInt()
    }
    solve(n, a)
}
