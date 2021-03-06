import java.io.BufferedInputStream
import java.io.InputStream
import java.io.PrintWriter
import java.util.StringTokenizer

val pw = PrintWriter(System.out)
const val INF = 10000000000000L

fun solve(A: Long, B: Long, Q: Long, s: LongArray, t: LongArray, x: LongArray) {
    repeat(Q.toInt()) {
        var sp = - s.binarySearch(x[it]) - 1
        var tp = - t.binarySearch(x[it]) - 1
        var sdist = Math.min(x[it] - s.getOrElse(sp - 1) { -INF }, s.getOrElse(sp) { INF } - x[it])
        var tdist = Math.min(x[it] - t.getOrElse(tp - 1) { -INF }, t.getOrElse(tp) { INF } - x[it])
        pw.println(Math.min(sdist, tdist) + sdist + tdist)
    }
    pw.flush()
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

// Generated by 1.1.4 https://github.com/kyuridenamida/atcoder-tools  (tips: You use the default template now. You can remove this line by using your custom template)
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
    val A = sc.next().toLong()
    val B = sc.next().toLong()
    val Q = sc.next().toLong()
    val s = LongArray(A.toInt())
    for (i in 0 until A.toInt()) {
        s[i] = sc.next().toLong()
    }
    val t = LongArray(B.toInt())
    for (i in 0 until B.toInt()) {
        t[i] = sc.next().toLong()
    }
    val x = LongArray(Q.toInt())
    for (i in 0 until Q.toInt()) {
        x[i] = sc.next().toLong()
    }
    solve(A, B, Q, s, t, x)
}
