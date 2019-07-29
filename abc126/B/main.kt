import java.io.*
import java.util.*

val pw = PrintWriter(System.out)
fun solve(S: Int) {
    val a = S / 100
    val b = S % 100
    if (1 <= a && a <= 12) {
        if (1 <= b && b <= 12) {
            println("AMBIGUOUS")
            return
        }
        println("MMYY")
        return
    }
    if (1 <= b && b <= 12) {
        println("YYMM")
        return
    }
    println("NA")
    return
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
    val S = sc.next().toInt()
    solve(S)
}
