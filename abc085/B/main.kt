import java.io.*
import java.util.*

fun solve(N: Long, d: LongArray){
    println(d.distinct().size)
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
    val d = LongArray(N.toInt())
    for (i in 0 until N.toInt()) {
        d[i] = sc.next().toLong()
    }
    solve(N, d)
}

