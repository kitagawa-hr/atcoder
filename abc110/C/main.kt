import java.io.*
import java.util.*

const val YES = "Yes"
const val NO = "No"
// |S| ~ 10 ^ 5
// 文字の置換('a' <-> 'b')でS -> Tにできるか
fun solve(S: String, T: String) {
    val cache1 = mutableMapOf<Int, Int>()
    val cache2 = mutableMapOf<Int, Int>()
    for (i in 0 until S.length) {
        val s = S[i].toInt() - 97
        val t = T[i].toInt() - 97
        if(s in cache1.keys && cache1[s]!! != t){
            println(NO)
            return
        }
        if(t in cache2.keys && cache2[t]!! != s){
            println(NO)
            return
        }
        cache1[s] = t
        cache2[t] = s
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
    val S = sc.next()
    val T = sc.next()
    solve(S, T)
}
