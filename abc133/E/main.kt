import java.io.*
import java.util.*

const val MOD = 1000000007L

fun solve(N: Int, K: Int, a: IntArray, b: IntArray) {
    val tree = Array<MutableList<Int>>(N) { mutableListOf() }
    val stack = ArrayDeque<Int>()
    for (i in 0 until (N - 1)) { tree[a[i] - 1].add(b[i] - 1) }
    val dp = LongArray(N) { -1L }
    dp[0] = K.toLong()
    var ret = K.toLong()
    stack.addLast(0)
    while (stack.size > 0) {
        val parent = stack.removeLast()
        val nodes = tree[parent]
        for (i in 0 until nodes.size){
            var node = nodes[i]
            dp[node] = ret - i -1
        }
        if (stack.size > 0) ret = stack.getLast().toLong()
    }
    // println(dp.contentToString())
    var ans = dp.filter { it != -1L }.reduce { a, b -> a * b % MOD }
    println(ans % MOD)
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
    val K = sc.next().toInt()
    val a = IntArray((N - 1))
    val b = IntArray((N - 1))
    for (i in 0 until (N - 1)) {
        a[i] = sc.next().toInt()
        b[i] = sc.next().toInt()
    }
    solve(N, K, a, b)
}
