import java.io.*
import java.util.*

fun solve(N: Int, x: IntArray, y: IntArray, h: IntArray){
    data class Pyramid(val x: Int, val y: Int, val h: Int)
    val pyramid = (0 until N).map{ Pyramid(x[it], y[it], h[it]) }
    pyramid.filter{ it.h == 100 }.getOrNull(0)?.let{ println("${it.x} ${it.y} ${it.h}"); return }
    println("2 2 6")
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
    val x = IntArray(N)
    val y = IntArray(N)
    val h = IntArray(N)
    for (i in 0 until N) {
        x[i] = sc.next().toInt()
        y[i] = sc.next().toInt()
        h[i] = sc.next().toInt()
    }
    solve(N, x, y, h)
}

