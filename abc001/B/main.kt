import java.io.BufferedInputStream
import java.util.StringTokenizer


const val MOD = 5

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
    val m = sc.next().toLong()
    solve(m)
}

fun solve(m: Long){
    val n = m.toFloat() / 1000f
    when{
        (n < 0.1) -> { println("00") }
        (n <= 0.9)  -> { print("0"); println((n*10).toInt()) }
        (n <= 5)  -> { println((n*10).toInt()) }
        (n <= 30) -> { println((n + 50).toInt()) }
        (n <= 70) -> { println((80+(n-30)/5).toInt()) }
        else -> { println(89) }
    }
    return
}
