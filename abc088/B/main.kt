import java.io.*
import java.util.*

fun solve(N: Long, a: LongArray){
    a.sort()
    val n = N.toInt()
    val p = (0 until n step 2).map{ a[it] }.sum()
    val q = (1 until n step 2).map{ a[it] }.sum()
    println(Math.abs(p-q))
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
    val a = LongArray(N.toInt())
    for (i in 0 until N.toInt()) {
        a[i] = sc.next().toLong()
    }
    solve(N, a)
}

