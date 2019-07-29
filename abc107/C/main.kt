import java.io.*
import java.util.*

// N のうち K　のxを訪れる最小歩数
fun solve(N: Int, K: Int, x: IntArray) {
    if (K == 0) {
        println(0)
        return
    }
    val boundary = x.toList().lowerBound(0)
    val negatives = x.slice(0..boundary - 1).asReversed().map { -it.toLong() }
    val positives = x.slice(boundary until N).map { it.toLong() }
    // i だけ negativesからとる
    val INF = 1000000000000L
    var ans = Math.min(
            negatives.getOrElse(K - 1) { INF },
            positives.getOrElse(K - 1) { INF })
    for (i in 1 until K) {
        if (i - 1 >= negatives.size || K - i - 1 >= positives.size || K - i - 1 < 0) continue
        val step1 = 2 * negatives[i - 1] + positives[K - i - 1]
        val step2 = negatives[i - 1] + 2 * positives[K - i - 1]
        ans = Math.min(ans, Math.min(step1, step2))
    }
    println(ans)
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
    val x = IntArray(N)
    for (i in 0 until N) {
        x[i] = sc.next().toInt()
    }
    solve(N, K, x)
}

