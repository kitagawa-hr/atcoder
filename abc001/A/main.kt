import java.io.BufferedInputStream
import java.util.StringTokenizer



// Generated by 1.1.4 https://github.com/kyuridenamida/atcoder-tools  (tips: You use the default template now. You can remove this line by using your custom template)
fun main(args: Array<String>) {
    fun StringArray(size: Int, init: (Int) -> String = { "\u0000" }): Array<String> {
        return Array<String>(size, init)
    }
    class Scanner() {
        private val reader = BufferedInputStream(System.`in`).bufferedReader()
        private val tokens = StringTokenizer(reader.use { it.readText() })
        fun next() = tokens.nextToken()
    }
    val sc = Scanner()
    val H = LongArray(2.toInt())
    for (i in 0 until 2.toInt()) {
        H[i] = sc.next().toLong()
    }
    solve(H)
}

fun solve(H: LongArray){
    println(H[0] - H[1])
    return
}

