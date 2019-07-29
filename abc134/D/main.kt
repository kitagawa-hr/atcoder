import java.io.*
import java.util.*

val pw = PrintWriter(System.out)
fun solve(N: Int, a: IntArray) {
    val b = IntArray(N + 1)
    var left = N / 2 + 1
    var right = N
    for (i in left..right) b[i] = a[i - 1]
    right = left - 1
    for (i in right downTo 1) {
        b[i] = (a[i - 1] - (2 * i..N step i).map { b[it] }.sum()) % 2
    }
    val ans = b.withIndex().filter { it.value != 0 }.map { Math.abs(it.index) }
    println(ans.size)
    if (ans.size > 0) { pw.println(ans.joinToString(separator = " ")) }
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
<<<<<<< HEAD
    val N = sc.next().toInt()
    val a = IntArray(N)
    for (i in 0 until N) {
        a[i] = sc.next().toInt()
    }
    solve(N, a)
}
=======
    val N = sc.next().toLong()
    val a = LongArray(N.toInt())
    for (i in 0 until N.toInt()) {
        a[i] = sc.next().toLong()
    }
    solve(N, a)
}

>>>>>>> 15108b522615e7a52123e53d5c4370bb546087e2
