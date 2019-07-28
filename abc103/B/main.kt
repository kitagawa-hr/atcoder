import java.io.*
import java.util.*

const val YES = "Yes"
const val NO = "No"
fun solve(S: String, T: String){
    if (S == T ){println(YES); return}
    val len = S.length
    // i文字切り取り
    // i = 3, len = 5: "abcde" -> "cde"(2..4) + "ab"(0..1)
    for (i in 1..len - 1){
        val s = S.slice(len - i..len - 1 ) + S.slice(0..len - i - 1)
        if (s == T) {println(YES); return}
    }
    println(NO)
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

