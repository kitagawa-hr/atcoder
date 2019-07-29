import java.io.*
import java.util.*

fun solve(N: Int, S: String){
    var ans =0
    for(i in 1 until N - 1){
        ans = Math.max(ans, calc(S.slice(0 until i), S.slice(i until N)))
    }
    println(ans)
    return
}

fun calc(a: String, b: String): Int{
    return a.toSet().distinct().count{ it in b }
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
    val S = sc.next()
    solve(N, S)
}

