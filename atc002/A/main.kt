import java.io.BufferedInputStream
import java.io.InputStream
import java.util.ArrayDeque
import java.util.StringTokenizer

fun solve(R: Int, C: Int, sx: Int, sy: Int, gx: Int, gy: Int, maze: Array<String>) {
    val maze_step = Array<IntArray>(R) { IntArray(C) }
    val dq = ArrayDeque<Pair<Int, Int>>()
    dq.addLast(Pair(sy - 1, sx - 1))
    while (dq.size > 0) {
        var yx = dq.removeFirst()
        var step = maze_step[yx.first][yx.second]
        var yx_next = listOf(
            Pair(yx.first - 1, yx.second),
            Pair(yx.first + 1, yx.second),
            Pair(yx.first, yx.second - 1),
            Pair(yx.first, yx.second + 1)
        )
        for (nyx in yx_next) {
            var y = nyx.first
            var x = nyx.second
            if (y < 0 || y >= R) { continue }
            if (x < 0 || x >= C) { continue }
            if (maze[y][x] == '#') { continue }
            if (x == gx - 1 && y == gy - 1) {
                println(step + 1)
                // maze_step[y][x] = step
                // for (steps in maze_step){
                //     println(steps.contentToString())
                // }
                return
            }
            if (maze_step[y][x] == 0) {
                maze_step[y][x] = step + 1
                dq.addLast(Pair(y, x))
            }
        }
    }
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
    val (R, C) = readLine()!!.split(" ").map { it.toInt() }
    val (sy, sx) = readLine()!!.split(" ").map { it.toInt() }
    val (gy, gx) = readLine()!!.split(" ").map { it.toInt() }
    val maze = StringArray(R) { readLine()!! }
    solve(R, C, sx, sy, gx, gy, maze)
}
