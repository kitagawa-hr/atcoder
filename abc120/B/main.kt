import java.io.*
import java.util.*

var pw = PrintWriter(System.out)
fun solve(A: Int, B: Int, K: Int){
    var count = 0
    for (i in 100 downTo 1){
        if (A % i == 0 && B % i ==0){
            count++
        }
        if (count == K){
            println(i)
            return
        }
    }
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
    val A = sc.next().toInt()
    val B = sc.next().toInt()
    val K = sc.next().toInt()
    solve(A, B, K)
}

