import java.io.*
import java.util.*

fun solve(n: Int, v: IntArray){
    if (v.distinct().size == 1){
        println(n / 2)
        return
    }
    val v1 = v.slice(0 until n step 2).groupBy{it}.toList().sortedByDescending{ it.second.size }
    val v2 = v.slice(1 until n step 2).groupBy{it}.toList().sortedByDescending{ it.second.size }
    if (v1[0].first == v2[0].first){
            val candidates = listOf(
                n - v1[0].second.size - v2[1].second.size,
                n - v1[1].second.size - v2[0].second.size
            )
            println(candidates.min())
    }else{
        println(n - v1[0].second.size - v2[0].second.size  )
    }
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
    val n = sc.next().toInt()
    val v = IntArray(n)
    for (i in 0 until n) {
        v[i] = sc.next().toInt()
    }
    solve(n, v)
}

