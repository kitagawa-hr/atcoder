import java.io.*
import java.util.*

import kotlin.Comparable

fun solve(N: Int, M: Int, a: IntArray, b: IntArray){
    data class Range(val a: Int, val b: Int) : Comparable<Range> {
        override fun compareTo(other: Range) = this.b - other.b
    }
    val ranges = (0 until M).map{ Range(a[it], b[it])}.sortedBy{ it.b }
    val destroyed = TreeSet<Int>()
    for(range in ranges){
        destroyed.ceiling(range.a)?: destroyed.add(range.b - 1)
    }
    println(destroyed.size)
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

