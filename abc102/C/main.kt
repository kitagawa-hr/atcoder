import java.io.*
import java.util.*

fun solve(N: Int, A: IntArray){
    val diffs = A.mapIndexed{ idx, it -> it - idx - 1 }.sorted()
    val b1 = N/2
    val ans = diffs.map{ Math.abs(it - diffs[b1]).toLong() }.sum()
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
    val A = IntArray(N)
    for (i in 0 until N) {
        A[i] = sc.next().toInt()
    }
    solve(N, A)
}

