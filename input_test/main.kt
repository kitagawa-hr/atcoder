import java.io.BufferedInputStream
import java.io.InputStream
import java.util.StringTokenizer

// Generated by 1.1.4 https://github.com/kyuridenamida/atcoder-tools  (tips: You use the default template now. You can remove this line by using your custom template)
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
    val N = tokens.next().toInt()
    val A = IntArray(N)
    val B = IntArray(N)
    val C = IntArray(N)
    for (i in 0 until N) {
        A[i] = tokens.next().toInt()
        B[i] = tokens.next().toInt()
        C[i] = tokens.next().toInt()
    }
    println(C[N - 1])
}
