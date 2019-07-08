import java.io.*
import java.util.*

fun solve(H: Int, W: Int, S: Array<String>){
    val L = Array<IntArray>(H){ IntArray(W){ 0 } }
    val R = Array<IntArray>(H){ IntArray(W){ 0 } }
    val U = Array<IntArray>(H){ IntArray(W){ 0 } }
    val D = Array<IntArray>(H){ IntArray(W){ 0 } }
    for ( y in 0 until H ){
        for ( x in 0 until W ){
            if (S[y][x] == '#' ){
                R[y][x] = -1
                U[y][x] = -1
                continue }
            R[y][x] = if (x == 0) 0 else R[y][x - 1] + 1
            U[y][x] = if (y == 0) 0 else U[y - 1][x] + 1
        }
    }
    for ( y in H - 1 downTo 0 ){
        for ( x in W - 1 downTo 0 ){
            if (S[y][x] == '#' ){
                L[y][x] = -1
                D[y][x] = -1
                continue }
            L[y][x] = if (x == W - 1 ) 0 else L[y][x + 1] + 1
            D[y][x] = if (y == H - 1 ) 0 else D[y + 1][x] + 1
        }
    }
    var ans = 0
    for ( y in 0 until H ){
        for ( x in 0 until W ){
            if (R[y][x] < 0 ||  L[y][x] <0 || U[y][x] < 0 || D[y][x] < 0){ continue }
            var lamp = R[y][x] + L[y][x] + U[y][x] + D[y][x] + 1
            ans = Math.max(ans, lamp)
        }
    }
    println(ans)
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
    val H = sc.next().toInt()
    val W = sc.next().toInt()
    val S = StringArray(H)
    for (i in 0 until H) {
        S[i] = sc.next()
    }
    solve(H, W, S)
}

