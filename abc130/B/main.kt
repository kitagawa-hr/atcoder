import java.io.BufferedInputStream



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
    val N = tokens.next().toLong()
    val X = tokens.next().toLong()
    val L = LongArray(N.toInt())
    for(i in 0 until N.toInt()){
        L[i] = tokens.next().toLong()
    }
    solve(N, X, L)
}

fun solve(N: Long, X: Long, L: LongArray){
    return
}

