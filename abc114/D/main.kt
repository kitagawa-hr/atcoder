import java.io.*
import java.util.*

// N!の約数のうち,約数の数が75のものの数
// P[ai^bi] -> P(1+bi)
// 75 = 3 * 5 ^ 2 -> (2, 4, 4), (2, 24)
// 10以下の素数 -> 2, 3, 5, 7
// 11 - 97 は21個ある
val primes = listOf(
    2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
    43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97
)
fun solve(N: Int) {
    val divisors = primes.map { divisor(N, it) }
    val one = divisors.size
    // (2, 4, 4) -> 3 * 5 * 5 = 75
    val four = divisors.filter { it >= 4 }.size
    val two = divisors.filter { it >= 2 }.size
    val s1 = four * (four - 1) / 2 * (two - 2)
    // (2, 24) -> 3 * 25 = 75
    val twentyFour = divisors.filter { it >= 24 }.size
    val s2 = twentyFour * (two - 1)
    // (4, 14) -> 5 * 15 = 75
    val fourTeen = divisors.filter { it >= 14 }.size
    val s4 = fourTeen * (four - 1)
    // (0, 74) -> 1 * 75 = 75
    val s3 = divisors.filter { it >= 74 }.size
    println(s1 + s2 + s3 + s4)
    return
}

// n!がxで何回割り切れるか
fun divisor(n: Int, x: Int): Int = if (n / x < 1) 0 else n / x + divisor(n / x, x)

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
