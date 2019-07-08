import java.io.BufferedInputStream
import java.io.InputStream
import java.util.StringTokenizer


const val YES = "Yes"
const val NO = "No"

fun findStart(maze: Array<String>): Pair<Int, Int>{
    for (h in 0 until maze.size){
        for (w in 0 until maze[0].length){
            if (maze[h][w] == 's'){
                return Pair(h, w)
            }
        }
    }
    return 0 to 0
}

fun solve(H: Int, W: Int, maze: Array<String>){
    val (sh, sw) = findStart(maze)
    val cache = Array<IntArray>(H){ IntArray(W) }
    fun dfs(h: Int, w: Int): Boolean{
        if (h >= H || h < 0 || w <0 || w>= W){return false}
        if (cache[h][w] == 1) return false
        cache[h][w] = 1
        when(maze[h][w]){
            '#' -> { return false }
            'g' -> { return true }
        }
        return dfs(h+1, w) || dfs(h-1, w) || dfs(h, w+1) || dfs(h, w-1)
    }
    val ans =if (dfs(sh, sw)) YES else NO
    println(ans)
    return
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
    val (H, W) = readLine()!!.split(" ").map{ it.toInt() }
    val maze = StringArray(H){ readLine()!! }
    solve(H, W, maze)
}