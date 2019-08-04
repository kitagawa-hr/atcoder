import java.io.*
import java.util.*

fun solve(D: Long, N: Long){
    val ans = (1..101)
        .map{ it*Math.pow(100.toDouble(), D.toDouble()) }
        .map{ it.toInt() }
    println(if(N==100L) ans[N.toInt()] else ans[N.toInt()-1])
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
    val D = sc.next().toLong()
    val N = sc.next().toLong()
    solve(D, N)
}

