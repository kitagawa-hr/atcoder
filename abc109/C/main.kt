import java.io.*
import java.util.*

val pw = PrintWriter(System.out)
fun solve(N: Long, X: Long, x: LongArray){
    val ans = x.map{ Math.abs(it - X) }.reduce{ a,b -> gcd(a,b) }
    println(ans)
    return
}

fun gcd(x: Long, y: Long): Long = if (y == 0L) x else gcd(y, x % y)

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
    val X = sc.next().toLong()
    val x = LongArray(N.toInt())
    for (i in 0 until N.toInt()) {
        x[i] = sc.next().toLong()
    }
    solve(N, X, x)
}

