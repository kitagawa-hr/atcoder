import java.io.*
import java.util.*

// N以下で a % b >= Kとなる(a,b)の組
fun solve(N: Int, K: Int) {
    // N = b*p + r
    // p*(b-k) + max(0, r-K)
    if (K == 0){
        println(N.toLong()*N.toLong())
        return
    }
    var ans = 0L
    for (b in K+1..N) {
        // remainder = p*{0,1,2...b-1} + {0,1,2,...r}
        val r = N % b
        val p = (N - r) / b
        ans += p * (b - K) + Math.max(0, r - K + 1)
    }
    println(ans)

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
    val K = sc.next().toInt()
    solve(N, K)
}
