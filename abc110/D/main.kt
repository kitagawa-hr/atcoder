import java.io.*
import java.util.*

const val MOD = 1000000007
// N ~ 10 ^ 5
// M ~ 10 ^ 9
fun solve(N: Int, M: Int) {
    // m = PRODUCT(p_i^q_i)
    // [q_i]をNグループに分ける
    // q_i と | * N-1を並べる N + |q_i|  - 1 C |qi|
    // 12 = 2^3 * 3 -> (3, 1) -> 4C3 * 3C1
    val factors = PrimeUtils.primeFactorize(M).map{ it.value }
    val factorials = LongArray(N + 1)
    factorials[1] = 2
    for (n in 2..N){factorials[n] = n * factorials[n-1] % MOD}
    return
}



object PrimeUtils {
    fun isPrime(num: Long): Boolean {
        if (num == 1L) return false
        if (num in listOf(2L, 3L)) return true
        if (num % 6 in listOf(0L, 2L, 3L, 4L)) return false
        val sqrt = Math.sqrt(num.toDouble()).toLong()
        for (n in 5..sqrt step 6) {
            if (num % n == 0L) return false
        }
        for (n in 7..sqrt step 6) {
            if (num % n == 0L) return false
        }
        return true
    }

    fun generatePrimesBelow(sup: Long): Sequence<Long> {
        if (sup < 2L) return sequenceOf()
        if (sup < 3L) return sequenceOf(2L)
        val seq = (0..sup / 6L)
                .asSequence()
                .flatMap { sequenceOf(6 * it + 5L, 6 * it + 7L) }
                .filter { it < sup }
        return sequenceOf(2L, 3L) + seq.filter { isPrime(it) }
    }

    fun primeFactorize(num: Long): Map<Long, Int> {
        var n = num
        val result = mutableMapOf<Long, Int>()
        val sqrt = Math.sqrt(num.toDouble()).toLong()
        val trialDivs = sequenceOf(2L) + (3..sqrt step 2).asSequence()
        for (trialDiv in trialDivs) {
            if (trialDiv > n) break
            val divideRes = iterateDivide(n, trialDiv)
            if (divideRes.first > 0) {
                result[trialDiv] = divideRes.first
                n = divideRes.second
            }
        }
        if (n != 1L) result[n] = 1
        return result
    }
}


fun iterateDivide(num: Long, divisor: Long): Pair<Int, Long> {
    var n = num
    var count = 0
    while (num != 0L && n % divisor == 0L) {
        n /= divisor
        count++
    }
    return Pair(count, n)
}
fun getDivisors(num: Int): List<Int>{
    val lis = mutableListOf<Int>(1)
    val limit = Math.sqrt(num.toDouble()).toInt()
    var x = 2
    while(x <= limit){
        if (num % x == 0) lis.add(x)
        x++
    }
    return lis
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
    val M = sc.next().toInt()
    solve(N, M)
}
