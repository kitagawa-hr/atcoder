import java.io.*
import java.util.*

fun solve(N: Long, T: Long, c: LongArray, t: LongArray){
    val ans = (0 until N.toInt()).map{ c[it] to t[it] }.filter{ it.second <= T }.minBy{ it.first }?.first
    println(ans?: "TLE")
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
    val T = sc.next().toLong()
    val c = LongArray(N.toInt())
    val t = LongArray(N.toInt())
    for (i in 0 until N.toInt()) {
        c[i] = sc.next().toLong()
        t[i] = sc.next().toLong()
    }
    solve(N, T, c, t)
}

