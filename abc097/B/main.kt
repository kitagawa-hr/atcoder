import java.io.*
import java.util.*

var pw = PrintWriter(System.out)
const val m = 31
fun solve(X: Int){
    var lis = mutableListOf<Int>(1)
    for (i in 2..m){
        var num = i * i
        while(num<=1000){
            lis.add(num)
            num *= i
        }
    }
    println(lis.sorted().findLast{ it <= X }!!)
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
    val X = sc.next().toInt()
    solve(X)
}

