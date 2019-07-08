import java.io.*
import java.util.*

var pw = PrintWriter(System.out)

fun getBit(x: Long, digit: Int): Long{
    // 二進法表示でdigit桁目の数字
    return x shr digit and 1
}

// Aiを2進数表示して、各桁ごとに1が多ければ0, 0が多ければ1を選択していくと最大にできる
// あとはKを超えないように桁DPをする
fun solve(N: Int, K: Long, A: LongArray){
    // Kの二進法表示
    val K2 = K.toString(radix=2).reversed()
    val kLength = K2.length
    val oneOrZero = IntArray(kLength)
    for ( i in 0 until kLength ){
        var oneCount = A.map{ getBit(it, i) }.count{ it == 1L }
        oneOrZero[i] = if oneCount < N / 2 0 else 1
    }
    val dp = IntArray(kLength)
    for (i in 0 until kLength){
        if (K2[i].toString().toInt() > oneOrZero[i]){
            
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
    val K = sc.next().toLong()
    val A = LongArray(N)
    for (i in 0 until N) {
        A[i] = sc.next().toLong()
    }
    solve(N, K, A)
}

