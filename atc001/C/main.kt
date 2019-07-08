import java.io.*
import java.util.*

var pw = PrintWriter(System.out)

// A, Bから1つずつ選んで和がkとなる組み合わせの和を求める
// k = 1, 2, 3, ... 2*N
// N ~ O(10^5)
fun solve(N: int, A: intArray, B: intArray){
    fun find(i: Int){
        
    }
    for (k in 1..2*N){
        find(k)
    }
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
    val N = sc.next().toInt()
    val A = intArray(N)
    val B = intArray(N)
    for (i in 0 until N) {
        A[i] = sc.next().toInt()
        B[i] = sc.next().toInt()
    }
    solve(N, A, B)
}

