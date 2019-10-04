import java.io.*
import java.util.*

enum class Direction { LEFT, UP, LEFTUP, NODIRECTION }
data class Lcs(var length: Int, var direction: Direction)
fun solve(s: String, t: String) {
    // dp[i][j] = sからi, tからj文字使ったときのLCS
    val dp = Array(s.length + 1) { IntArray(t.length + 1) }
    for (i in 1..s.length) {
        for (j in 1..t.length) {
            dp[i][j] = when (s[i - 1] == t[j - 1]) {
                true -> dp[i - 1][j - 1] + 1
                false -> Math.max(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }
    val ans = StringBuilder()
    var y = s.length
    var x = t.length
    while (y > 0 && x > 0) {
        when (dp[y][x]) {
            dp[y - 1][x] -> { y-- }
            dp[y][x - 1] -> { x-- }
            dp[y - 1][x - 1] + 1 -> { ans.append(s[y - 1]); x--; y-- }
            else -> {}
        }
    }
    println(ans.reversed())
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
    val s = sc.next()
    val t = sc.next()
    solve(s, t)
}
