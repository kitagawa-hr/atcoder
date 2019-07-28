import java.io.*
import java.util.*

fun solve(S: String, K: Long){
    if (S.all{ it == '1' }) {
        println('1')
        return
    }
    val i = S.indexOfFirst{ it != '1' }!!
    println(if (K <= i.toLong()) 1 else S[i])
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
    val K = sc.next().toLong()
    solve(S, K)
}

