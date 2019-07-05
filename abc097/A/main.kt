import java.io.*
import java.util.*

var pw = PrintWriter(System.out)
const val YES = "Yes"
const val NO = "No"
fun solve(a: Long, b: Long, c: Long, d: Long){
    if (Math.abs(a - c) <= d){ println(YES) }
    else if(Math.abs(a-b) <= d && Math.abs(b-c) <= d){ println(YES) }
    else{ println(NO) }
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
    val a = sc.next().toLong()
    val b = sc.next().toLong()
    val c = sc.next().toLong()
    val d = sc.next().toLong()
    solve(a, b, c, d)
}

