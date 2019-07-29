import java.io.*
import java.util.*

fun solve(N: Long, A: LongArray){
    val n = N.toInt()
    var ans = 0
    val cumSum = A.toList().scanLeft(0L){a, b -> a + b}.toList()
    val cumXor = A.toList().scanLeft(0L){a, b -> a xor b}.toList()
    val stack = ArrayDeque<Int>()
    var j = 0
    var k = n - 1
    for(i in 0 until n){
        while(j <= k){
            if (cumSum[j] - cumSum.getOrElse(i-1){0} == cumXor[j] xor cumXor.getOrElse(i-1){0}){
                ans++
            }
            j++
        }
        k = j
    }
    println(ans)
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
    val N = sc.next().toLong()
    val A = LongArray(N.toInt())
    for (i in 0 until N.toInt()) {
        A[i] = sc.next().toLong()
    }
    solve(N, A)
}

