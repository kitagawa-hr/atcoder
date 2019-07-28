import java.io.*
import java.util.*

const val YES = "YES"
const val NO = "NO"
fun solve(N: Long, p: LongArray){
    val sp = p.sorted()
    val a = p.filterIndexed{ index, it -> it != sp[index] }
    if(a.size==0){println(YES); return}
    else if (a.size != 2){ println(NO); return }
    val b = sp.filterIndexed{ index, it -> it != p[index] }
    if (a[0] == b[1] && a[1] == b[0]){println(YES)}
    else println(NO)
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
    val p = LongArray(N.toInt())
    for (i in 0 until N.toInt()) {
        p[i] = sc.next().toLong()
    }
    solve(N, p)
}

