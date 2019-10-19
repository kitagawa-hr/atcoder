import java.io.*
import java.util.*

const val YES = "Yes"
const val NO = "No"
// 141414...1422222...4141
fun solve(N: Int, a: IntArray){
    val fours = a.count{ it % 4 == 0 }
    val twos = a.count{ it % 2 == 0 && it % 4 != 0 }
    val odds = a.count{ it % 2 != 0}
    val ret = if(twos == 0) fours + 1 else fours
    if(odds > ret) println(NO)
    else println(YES)
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
    val a = IntArray(N)
    for (i in 0 until N) {
        a[i] = sc.next().toInt()
    }
    solve(N, a)
}

