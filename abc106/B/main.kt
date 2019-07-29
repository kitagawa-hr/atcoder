import java.io.*
import java.util.*

fun solve(N: Long){
    var count = 0
    for (n in 1..N step 2){
        if(countDivisor(n)==8) count++
    }
    println(count)
    return
}

fun countDivisor(n: Long): Int{
    var count = 0
    for (i in 1..n){
        if (n % i == 0L ) count++
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
    solve(N)
}

