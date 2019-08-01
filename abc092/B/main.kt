import java.io.*
import java.util.*

fun solve(N: Long, D: Long, X: Long, A: LongArray){
    fun calc(x: Long): Int{
        return (1..D step x).toList().size
    }
    val ans = X + A.map{ calc(it) }.sum()
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
    val N = sc.next().toLong()
    val D = sc.next().toLong()
    val X = sc.next().toLong()
    val A = LongArray(N.toInt())
    for (i in 0 until N.toInt()) {
        A[i] = sc.next().toLong()
    }
    solve(N, D, X, A)
}

