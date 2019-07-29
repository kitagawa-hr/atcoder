import java.io.*
import java.util.*

// (x0,y0)=(0,0)
// モードが L のとき，(xi,yi)=(xi−1−di, yi−1)
// モードが R のとき，(xi,yi)=(xi−1+di, yi−1)
// モードが D のとき，(xi,yi)=(xi−1,    yi−1−di)
// モードが U のとき，(xi,yi)=(xi−1,    yi−1+di)
fun solve(N: Long, X: LongArray, Y: LongArray){return}
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
    val X = LongArray(N.toInt())
    val Y = LongArray(N.toInt())
    for (i in 0 until N.toInt()) {
        X[i] = sc.next().toLong()
        Y[i] = sc.next().toLong()
    }
    solve(N, X, Y)
}

