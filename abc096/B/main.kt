import java.io.*
import java.util.*

fun solve(A: Long, B: Long, C: Long, K: Long) {
    val abc = listOf(A, B, C).sorted()
    println(abc[0] + abc[1] + abc[2]*Math.pow(2.toDouble(), K.toDouble()).toLong())
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
    val A = sc.next().toLong()
    val B = sc.next().toLong()
    val C = sc.next().toLong()
    val K = sc.next().toLong()
    solve(A, B, C, K)
}
