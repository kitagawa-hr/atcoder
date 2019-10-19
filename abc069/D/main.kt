import java.io.*
import java.util.*

val pw = PrintWriter(System.out)
fun solve(H: Int, W: Int, N: Int, a: IntArray){
    val ans = IntArray(H * W)
    var cur = 0
    for(i in 0 until N){
        for(j in 0 until a[i]){
            ans[cur] = i + 1
            cur++
        }
    }
    for(h in 0 until H){
        val ret = ans.slice(h*W until h*W + W)
        if(h % 2 == 0){ pw.println(ret.joinToString(separator=" ")) }
        else pw.println(ret.reversed().joinToString(separator=" "))
    }
    pw.flush()
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
    val H = sc.next().toInt()
    val W = sc.next().toInt()
    val N = sc.next().toInt()
    val a = IntArray(N)
    for (i in 0 until N) {
        a[i] = sc.next().toInt()
    }
    solve(H, W, N, a)
}

