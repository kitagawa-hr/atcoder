import java.io.*
import java.util.*

fun solve(N: Int, M: Int, x: LongArray, y: LongArray, z: LongArray){
    val xyz = (0 until N).map { Triple(x[it], y[it], z[it]) }
    // +++ ++- +-- ... の場合全てを試す
    val signs = listOf(1, -1)
    val patterns = product(signs, signs, signs)
    var ans = 0L
    for (pattern in patterns){
        val ret = xyz.map{
            pattern[0]*it.first + pattern[1]*it.second + pattern[2]*it.third
        }.sortedDescending()
        ans = Math.max(ans, ret.slice(0 until M).sum())
    }
    println(ans)
    return
}


fun <T> product(vararg lists: List<T>): List<List<T>> {
    fun <T> oneDimTimesOne(left: List<T>, right: List<T>): List<List<T>> =
            left.flatMap { lelem -> right.map { relem -> listOf(lelem, relem) } }

    fun <T> twoDimTimesOne(left: List<List<T>>, right: List<T>): List<List<T>> {
        val product = mutableListOf<List<T>>()
        for (list in left) {
            for (element in right) {
                product.add(list + listOf(element))
            }
        }
        return product
    }
    require(lists.size >= 2)
    return lists
            .drop(2)
            .fold(oneDimTimesOne(lists[0], lists[1])) { acc, suc -> twoDimTimesOne(acc, suc) }
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
    val M = sc.next().toLong()
    val x = LongArray(N.toInt())
    val y = LongArray(N.toInt())
    val z = LongArray(N.toInt())
    for (i in 0 until N.toInt()) {
        x[i] = sc.next().toLong()
        y[i] = sc.next().toLong()
        z[i] = sc.next().toLong()
    }
    solve(N.toInt(), M.toInt(), x, y, z)
}

