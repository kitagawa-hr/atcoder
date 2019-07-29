import java.io.*
import java.util.*

fun solve(N: Int, A: IntArray) {
    val tree = TreeSet<Int>()
    tree.add(A[0])
    var count = 1
    val map = mutableMapOf<Int, Int>()
    for (n in 1 until N){
        map[A[n]] = map.getOrElse(A[n]){ 1 } + 1
        // println("${A[n]} ${tree} $map")
        if (A[n] <= tree.first()){ count++ }
        else{
            tree.lower(A[n])?.let{
                if (map.getOrElse(it){ 1 } == 1){
                    map.remove(it)
                    tree.remove(it)
                }else{
                    map[it] = map[it]!! - 1
                }
            }
        }
        tree.add(A[n])
    }
    println(count)
    return
}

// fun solve(N: Int, A: IntArray) {
//     var ans = 1
//     var ret = A[0]
//     var count = 1
//     for (n in 1 until N){
//         if (A[n] <= ret){
//             count++
//             ret = A[n]
//         }else{
//             ans = Math.max(ans, count)
//             count = 1
//             ret = A[n]
//         }
//     }
//     ans = Math.max(ans, count)
//     println(ans)
// }


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
    val A = IntArray(N)
    for (i in 0 until N) {
        A[i] = sc.next().toInt()
    }
    solve(N, A)
}
