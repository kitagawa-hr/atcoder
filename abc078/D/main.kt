import java.io.*
import java.util.*

fun solve(N: Int, Z: Int, W: Int, a: IntArray){
    if (N == 1) println(Math.abs(a[0] - W))
    else println(Math.max(Math.abs(a.last() - W), Math.abs(a[N-2] - a.last())))
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
    val Z = sc.next().toInt()
    val W = sc.next().toInt()
    val a = IntArray(N)
    for (i in 0 until N) {
        a[i] = sc.next().toInt()
    }
    solve(N, Z, W, a)
}

