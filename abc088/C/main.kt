import java.io.*
import java.util.*

const val YES = "Yes"
const val NO = "No"
fun solve(c: Array<LongArray>){
    var trace = 0L
    var v = 0L
    for (i in 0..2){
        for(j in 0..2){
            if (i==j) trace += c[i][j]
            else v += c[i][j]
        }
    }
    if (v == 2*trace){
        println(YES)
    }else(println(NO))
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
    val c = Array<LongArray>(3.toInt()){ LongArray(3.toInt()) }
    for (i in 0 until 3.toInt()) {
        for (j in 0 until 3.toInt()) {
            c[i][j] = sc.next().toLong()
        }
    }
    solve(c)
}

