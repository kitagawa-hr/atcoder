import java.io.*
import java.util.*

var pw = PrintWriter(System.out)
fun solve(H: Int, W: Int, S: Array<String>){
    val ans = Array(H){ CharArray(W) }
    for(h in 0 until H){
        for(w in 0 until W){
            if (S[h][w] == '#') ans[h][w] = '#'
            else ans[h][w] = S.getAround(h, w).count{ it == '#' }.toC()
        }
    }
    ans.forEach{
        pw.println(it.joinToString(separator=""))
    }
    pw.flush()
    return
}

fun Int.toC(): Char = when(this){
    0 -> '0'
    1 -> '1'
    2 -> '2'
    3 -> '3'
    4 -> '4'
    5 -> '5'
    6 -> '6'
    7 -> '7'
    8 -> '8'
    9 -> '9'
    else -> '#'
}

fun Array<String>.safeGet(i: Int, j: Int): Char? = when{
    i < 0 || i >= size -> null
    else -> this[i].getOrNull(j)
}


fun Array<String>.getAround(i: Int, j: Int): List<Char> =
    (i-1..i+1)
        .flatMap{ y -> (j-1..j+1).map{ x -> y to x } }
        .map{ this.safeGet(it.first, it.second) }
        .filterNotNull()


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

