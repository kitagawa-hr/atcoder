import java.io.*
import java.util.*

fun solve(N: Int, A: Array<IntArray>){
    var ans = 0
    for (i in 0 until N){
        val sum1 = A[0].filterIndexed{ index, value -> index <= i }.sum()
        val sum2 = A[1].filterIndexed{ index, value -> index >= i }.sum()
        ans = Math.max(ans, sum1 + sum2)
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
    val A = Array<IntArray>(2.toInt()){ IntArray(N) }
    for (i in 0 until 2.toInt()) {
        for (j in 0 until N) {
            A[i][j] = sc.next().toInt()
        }
    }
    solve(N, A)
}

