import java.io.*
import java.util.*

fun solve(N: Int){
    if (N == 0){
        println(0)
        return
    }
    val ans = ArrayDeque<Int>()
    var n = N
    var ret = -2
    while(n != 0){
        if (n % ret != 0 ){
            ans.addFirst(1)
            n -= n % ret
        }else ans.addFirst(0)
        ret *= -2
    }
    ans.forEach{ print(it) }; println()
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
    solve(N)
}
