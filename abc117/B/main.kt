import java.io.*
import java.util.*

var pw = PrintWriter(System.out)
const val YES = "Yes"
const val NO = "No"
fun solve(N: Long, L: LongArray){
    val l = L.sortedDescending()
    if(l[0] < l.slice(1 until l.size).sum()) {
        pw.println(YES)
    }else{ pw.println(NO) }
    pw.flush()
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
    val N = sc.next().toLong()
    val L = LongArray(N.toInt())
    for (i in 0 until N.toInt()) {
        L[i] = sc.next().toLong()
    }
    solve(N, L)
}

