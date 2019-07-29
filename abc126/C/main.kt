import java.io.*
import java.util.*

fun solve(N: Int, K: Int) {
    var ans = 0.toDouble()
    for (s in 1..minOf(N, K - 1)) {
        ans += Math.pow(1 / 2.toDouble(), powerOfTwo(s, K).toDouble())
    }
    if (N >= K) {
        ans += N - K + 1
    }
    ans /= N
    println(ans)
    return
}

fun powerOfTwo(s: Int, k: Int): Int {
    var score = s
    var power = 0
    while (score < k) {
        score *= 2
        power += 1
    }
    return power
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
    solve(N, K)
}
