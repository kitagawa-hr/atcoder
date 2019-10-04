import java.io.*
import java.util.*

val pw = PrintWriter(System.out)
fun solve(X: String, Y: String){
    when{
        X < Y -> '<'
        X == Y -> '='
        X > Y -> '>'
        else -> ' '
    }.let{println(it)}
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
    val X = sc.next()
    val Y = sc.next()
    solve(X, Y)
}

