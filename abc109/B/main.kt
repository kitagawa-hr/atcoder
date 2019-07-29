import java.io.*
import java.util.*

const val YES = "Yes"
const val NO = "No"
fun solve(N: Long, W: Array<String>){
    val lis = mutableListOf<String>()
    lis.add(W[0])
    for ( i in 1 until N.toInt() ){
        if (W[i][0] != W[i-1].last()) {println(NO); return}
        if (W[i] in lis) {println(NO); return}
        lis.add(W[i])
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
    val N = sc.next().toLong()
    val W = StringArray(N.toInt())
    for (i in 0 until N.toInt()) {
        W[i] = sc.next()
    }
    solve(N, W)
}

