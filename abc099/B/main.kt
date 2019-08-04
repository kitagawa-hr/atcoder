import java.io.*
import java.util.*

fun solve(a: Int, b: Int){
    val heights = (1..999).scanLeft(0){a,b -> a+b}.toList()
    println(heights[b-a-1] - b)
    return
}

fun <T, R> Iterable<T>.scanLeft(initial: R, operation: (acc: R, T) -> R): Sequence<R> {
    var last = initial
    return this.asSequence().map { last = operation(last, it); last }
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
    val a = sc.next().toInt()
    val b = sc.next().toInt()
    solve(a, b)
}

