import java.io.*
import java.util.*

val pw = PrintWriter(System.out)
fun solve(N: Int, M: Int, P: IntArray, Y: IntArray) {
    val prefs = Array<MutableList<Int>>(N + 1) { mutableListOf<Int>() }
    val ps = (0 until M)
        .map { Pair(P[it], Y[it]) }
        .sortedBy { it.second }
    for (i in 0 until M) { prefs[ps[i].first].add(ps[i].second) }
    for (i in 0 until M) {
        val cityID = prefs[P[i]].binarySearch(Y[i]) + 1
        pw.println("${P[i]}".padStart(6, '0') + "$cityID".padStart(6, '0'))
    }
    pw.flush()
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
    val P = IntArray(M)
    val Y = IntArray(M)
    for (i in 0 until M) {
        P[i] = sc.next().toInt()
        Y[i] = sc.next().toInt()
    }
    solve(N, M, P, Y)
}
