import java.io.*
import java.util.*

fun solve(N: Int){
    val ds = listOf(111, 222, 333, 444, 555, 666, 777, 888, 999)
    val i = ds.map{ it - N }.withIndex().indexOfFirst{ it.value >= 0 }
    println(ds[i])
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

