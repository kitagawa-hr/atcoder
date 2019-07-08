import java.io.*
import java.util.*

fun solve(N: Long, A: LongArray){
    if (N == 2L){
        println(A.max())
        return
    }
    var ans = 0L
    val dp = Array<LongArray>(2){ LongArray(N.toInt()) }
    dp[0][0] = A[0]
    dp[1][N.toInt() - 1] = A[N.toInt() - 1]
    for (i in 1 until N.toInt()){
        dp[0][i] = gcd(dp[0][i-1], A[i])
    }
    for ( i in (N-2L).toInt() downTo 0 ){
        dp[1][i] = gcd(dp[1][i+1], A[i])
    }
    var s = 0L
    for ( i in 0 until N.toInt()){
        if (i == 0){ s = dp[1][1] }
        else if (i == N.toInt() - 1){ s = dp[0][N.toInt() - 2] }
        else{
            s = gcd(dp[0][i - 1], dp[1][i + 1])
        }
        ans = Math.max(s, ans)
    }
    println(ans)
    return
}

fun gcd(x: Long, y: Long): Long = if (y == 0L) x else gcd(y, x % y)

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
    val A = LongArray(N.toInt())
    for (i in 0 until N.toInt()) {
        A[i] = sc.next().toLong()
    }
    solve(N, A)
}
