import java.io.*
import java.util.*


fun solve(N: Int, A: LongArray){
    A.sort()
    val mA = A.filter{ it < 0L }
    val pA = A.filter{ it >= 0L }
    if (mA.size == 0){println(A.sum()); return}
    if (mA.size % 2 == 0){
        println(A.sum() - 2*mA.sum())
        return
    }
    if (pA.size == 0){
        println(2L*mA.last() - mA.sum())
        return
    }
    if(mA.last() + pA.first() < 0L ){
        println(A.sum() - 2L*mA.sum() - 2L*pA.first())
        return
    }else{
        println(A.sum() - 2L*mA.sum() + 2L*mA.last())
        return
    }
}

// Generated by 1.1.4 https://github.com/kyuridenamida/atcoder-tools  (tips: You use the default template now. You can remove this line by using your custom template)
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
    val A = LongArray(N)
    for(i in 0 until N){
        A[i] = sc.next().toLong()
    }
    solve(N, A)
}


