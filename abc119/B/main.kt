import java.io.BufferedInputStream
import java.io.InputStream
import java.util.StringTokenizer


fun solve(N: Long, x: DoubleArray, u: Array<String>){
    val unit = u.map{ if (it == "JPY") 1 else 380000 }
    val ans = x.mapIndexed{ index, it -> it * unit[index] }.sum()
    println(ans)
    return
}

// Generated by 1.1.4 https://github.com/kyuridenamida/atcoder-tools  (tips: You use the default template now. You can remove this line by using your custom template)
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
    val x = DoubleArray(N.toInt())
    val u = StringArray(N.toInt())
    for (i in 0 until N.toInt()) {
        x[i] = sc.next().toDouble()
        u[i] = sc.next()
    }
    solve(N, x, u)
}
