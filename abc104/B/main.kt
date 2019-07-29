import java.io.*
import java.util.*

fun solve(S: String) {
    if (S.get(0)!! == 'A' && S.slice(2..S.length - 2).count { it == 'C' } == 1 && S.count { it.toLowerCase() == it } == S.length - 2) {
        println("AC")
        return
    }
    println("WA")
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
    val S = sc.next()
    solve(S)
}
