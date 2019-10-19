import java.io.*
import java.util.*

const val YES = "POSSIBLE"
const val NO = "IMPOSSIBLE"
fun solve(N: Int, M: Int, a: IntArray, b: IntArray){
    val fromOne = a.withIndex().filter{ it.value == 1 }.map{ b[it.index] }.toSet()
    val toN = b.withIndex().filter{ it.value == N }.map{ a[it.index] }.toSet()
    if ((fromOne intersect toN).isEmpty()) println(NO)
    else println(YES)
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
    val a = IntArray(M)
    val b = IntArray(M)
    for (i in 0 until M) {
        a[i] = sc.next().toInt()
        b[i] = sc.next().toInt()
    }
    solve(N, M, a, b)
}

