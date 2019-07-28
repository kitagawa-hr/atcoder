import java.io.*
import java.util.*

fun solve(N: Long, D: Long){
    val r = 2*D + 1L
    val ans = (N/r) + if(N % r == 0L) 0L else 1L
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
    solve(N, D)
}

