import java.io.*
import java.util.*

fun solve(N: Long, A: LongArray, B: LongArray){
    val n = N.toInt()
    var ans = 0L
    var ans2 = 0L
    var rest = 0L
    var rest2 = 0L
    for ( i in 0 until n+1){
        var b = B.getOrElse(i){0} + rest
        if (A[i] > b){
            ans += b
            rest = 0
        }else{
            ans += A[i]
            if (rest >= A[i]){ rest = B.getOrElse(i){0} }
            else rest = b-A[i]
        }
    }
    for ( i in n - 1 downTo -1){
        var b = B.getOrElse(i){0} + rest2
        var a = A[i+1]
        if (a > b){
            ans2 += b
            rest2 = 0
        }else{
            ans2 += a
            if (rest2 >= a){ rest2 = B.getOrElse(i){0} }
            else rest2 = b-a
        }
    }
    println(Math.max(ans, ans2))
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
    val N = sc.next().toLong()
    val A = LongArray((N+1).toInt())
    for (i in 0 until (N+1).toInt()) {
        A[i] = sc.next().toLong()
    }
    val B = LongArray(N.toInt())
    for (i in 0 until N.toInt()) {
        B[i] = sc.next().toLong()
    }
    solve(N, A, B)
}

