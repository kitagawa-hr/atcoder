import java.io.*
import java.util.*

var pw = PrintWriter(System.out)
const val YES = "Yes"
const val NO = "No"
fun solve(N: Long, A: Long){
    println(if(N%500 <= A) YES else NO)
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
    val A = sc.next().toLong()
    solve(N, A)
}

