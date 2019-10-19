import java.io.*
import java.util.*

fun solve(K: Long){
    val offset = K / 50L
    val rest = K % 50L
    val ans = LongArray(50){ it.toLong() + offset - rest }
    for(i in 0 until rest.toInt()){
        ans[i] += 51L
    }
    println(50)
    println(ans.joinToString(separator=" "))
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
    val K = sc.next().toLong()
    solve(K)
}

