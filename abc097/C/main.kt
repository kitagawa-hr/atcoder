import java.io.*
import java.util.*

var pw = PrintWriter(System.out)
fun solve(s: String, K: Int){
    var substrings = mutableListOf<String>()
    for (i in 1..K){
        for (j in 0..s.length - i){
            substrings.add(s.slice(j until j + i))
        }
    }
    val subs = substrings.sorted().distinct()
    // println(subs)
    println(subs[K-1])
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
    val K = sc.next().toInt()
    solve(s, K)
}

