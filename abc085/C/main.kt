import java.io.*
import java.util.*

// solve
// a + b + c = N ~ 2000
// 10000a + 5000b + 1000c = Y ~ 10 ^ 7
// 10a + 5b + c = Y/1000 ~ 10^4
fun solve(N: Long, Y: Long){
    val n = N.toInt()
    val y = (Y/1000L).toInt()
    for (a in 0..n){
        for (b in 0..n){
            val c = n - a - b
            if (c < 0) continue
            if (y == 10*a + 5*b + c){
                println("$a $b $c")
                return
            }
        }
    }
    println("-1 -1 -1")
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
    val Y = sc.next().toLong()
    solve(N, Y)
}

