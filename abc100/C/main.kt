import java.io.*
import java.util.*

fun solve(N: Long, a: LongArray){
    println(a.map{ powerOfTwo(it.toInt()) }.sum())
    return
}

fun powerOfTwo(x: Int): Int{
    var count = 0
    var ret = x
    while(ret % 2 == 0){
        ret /=2
        count++
    }
    return count
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
    val a = LongArray(N.toInt())
    for (i in 0 until N.toInt()) {
        a[i] = sc.next().toLong()
    }
    solve(N, a)
}

