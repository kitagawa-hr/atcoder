import java.io.*
import java.util.*

var pw = PrintWriter(System.out)
fun solve(S: String){
    // RLのところだけ考えればよい
    // (RRR)RL(LLL)として、 Rからなら距離==Odd -> L, Even->R, Lからなら逆
    val N = S.length
    val posOfRL = mutableListOf<Int>()
    val ans = IntArray(N)
    for(i in 0 until N-1){
        if(S[i] == 'R' && S[i+1] == 'L'){
            posOfRL.add(i)
        }
    }
    for(i in 0 until N){
        if(S[i]=='R'){
            val pos = posOfRL.lowerBound(i)
            if((pos-i) % 2 == 0) ans[pos]++
            else ans[pos+1]++
        }else{
            val pos = posOfRL.lowerBound(i)
            if((pos-i) % 2 == 0) ans[pos+1]++
            else ans[pos]++
        }
    }
    println(ans.joinToString(separator=" "))
    return
}

fun <T : Comparable<T>> List<T?>.lowerBound(
        element: T,
        fromIndex: Int = 0,
        toIndex: Int = size
): Int {
    var low = fromIndex
    var high = toIndex
    while (low < high) {
        val mid = (low + high) / 2
        if (element <= this.get(mid)!!) {
            high = mid
        } else {
            low = mid + 1
        }
    }
    return low
}

fun <T : Comparable<T>> List<T?>.upperBound(
        element: T,
        fromIndex: Int = 0,
        toIndex: Int = size
): Int {
    var low = fromIndex
    var high = toIndex
    while (low < high) {
        val mid = (low + high) / 2
        if (element >= this.get(mid)!!) {
            low = mid + 1
        } else {
            high = mid
        }
    }
    return low
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
    val S = sc.next()
    solve(S)
}

