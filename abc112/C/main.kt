import java.io.*
import java.util.*

fun solve(N: Int, x: IntArray, y: IntArray, h: IntArray) {
    // z = max(0, H - |x-cx| - |y-cy|)
    if (100 in h) {
        val idx = h.indexOf(100)!!
        println("${x[idx]} ${y[idx]} 100")
        return
    }
    for (cx in 0..100) {
        for (cy in 0..100) {
            val dists = (0 until N)
                .filter{ h[it] != 0 }
                .map { h[it] + Math.abs(x[it] - cx) + Math.abs(y[it] - cy) }
                .distinct()
            if (dists.size == 1) {
                val H = dists[0]
                if ((0 until N)
                    .filter{ h[it] == 0 }
                    .map{ h[it] + Math.abs(x[it] - cx) + Math.abs(y[it] - cy) }.all{ it>=H }){
                    println("$cx $cy $H")
                    return
                }
            }
        }
    }
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
