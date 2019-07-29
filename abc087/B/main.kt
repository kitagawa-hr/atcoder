import java.io.*
import java.util.*

// 500A + 100B +  50C = X
fun solve(A: Int, B: Int, C: Int, X: Int){
    var ans = 0
    for (a in 0..A){
        for (b in 0..B){
            for (c in 0..C){
                if (500*a + 100*b + 50*c == X){
                    ans++
                }
            }
        }
    }
    println(ans)
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
    val C = sc.next().toInt()
    val X = sc.next().toInt()
    solve(A, B, C, X)
}

