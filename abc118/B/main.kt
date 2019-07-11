import java.io.*
import java.util.*

fun solve(N: Int, M: Int, A: List<IntArray>) {
    val record = IntArray(M)
    for (i in 0 until N) {
        A[i].forEach { record[it - 1] += 1 }
    }
    println(record.filter { it == N }.size)
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
    val M = sc.next().toInt()
    val A = mutableListOf<IntArray>()
    repeat(N) {
        val k = sc.next().toInt()
        val a = IntArray(k) { sc.next().toInt() }
        A.add(a)
    }
    solve(N, M, A)
}
