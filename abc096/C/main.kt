import java.io.*
import java.util.*

const val YES = "Yes"
const val NO = "No"

fun solve(H: Int, W: Int, s: Array<String>) {
    for (h in 0 until H) {
        for (w in 0 until W) {
            if (s[h][w] == '.') { continue }
            val adjacents = listOf(
                s.getOrDefault(h + 1, w, '.'),
                s.getOrDefault(h, w + 1, '.'),
                s.getOrDefault(h - 1, w, '.'),
                s.getOrDefault(h, w - 1, '.')
            )
            if (adjacents.count { it == '.' } == 4) {
                println(NO)
                return
            }
        }
    }
    println(YES)
    return
}

fun Array<String>.getOrDefault(i: Int, j: Int, default: Char): Char = when {
    (0 <= i && i < size) -> this[i].getOrElse(j) { default }
    else -> default
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
    val H = sc.next().toInt()
    val W = sc.next().toInt()
    val s = StringArray(H)
    for (i in 0 until H) {
        s[i] = sc.next()
    }
    solve(H, W, s)
}
