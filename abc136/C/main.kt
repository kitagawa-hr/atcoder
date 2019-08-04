import java.io.*
import java.util.*

const val YES = "Yes"
const val NO = "No"
fun solve(N: Int, H: IntArray){
    var ret = H[0] - 1
    for (i in 1 until N){
        if (H[i] > ret){
            H[i] -= 1
        }else if (H[i] < ret){
            println(NO)
            return
        }
        ret = H[i]
    }
    println(YES)
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
    val H = IntArray(N)
    for (i in 0 until N) {
        H[i] = sc.next().toInt()
    }
    solve(N, H)
}

