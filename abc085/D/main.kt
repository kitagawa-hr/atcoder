import java.io.*
import java.util.*

fun solve(N: Long, H: Long, a: LongArray, b: LongArray){
    // 投げる回数 i (<= N)
    // i回投げ(大きい方からi個), 攻撃力最大の武器で残りを攻撃
    val maxAttack = a.max()!!
    val cumSum = b.sortedDescending().scanLeft(0L){ a,b -> a+b }.toList()
    var ans = floorDiv(H, maxAttack)
    for (i in 1..N){
        val throwPt = cumSum[i.toInt()-1]
        val ret  =  i + floorDiv(Math.max(0, H-throwPt), maxAttack)
        ans = Math.min(ans, ret)
    }
    println(ans)
    return
}

fun <T, R> Iterable<T>.scanLeft(initial: R, operation: (acc: R, T) -> R): Sequence<R> {
    var last = initial
    return this.asSequence().map { last = operation(last, it); last }
}

fun floorDiv(a: Long, b: Long): Long = a / b + if ( a % b == 0L ) 0L else 1L

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
    val H = sc.next().toLong()
    val a = LongArray(N.toInt())
    val b = LongArray(N.toInt())
    for (i in 0 until N.toInt()) {
        a[i] = sc.next().toLong()
        b[i] = sc.next().toLong()
    }
    solve(N, H, a, b)
}

