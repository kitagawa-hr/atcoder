import java.io.*
import java.util.*

fun solve(H: Int, W: Int, s: Array<String>){
    val queue = ArrayDeque<Pair<Int, Int>>()
    queue.addLast(Pair(0,0))
    val whiteSum = s.map{ str -> str.count{ chr -> chr == '.' } }.sum()
    val cache = Array(H){ IntArray(W) }
    var step = 1
    while(queue.size > 0){
        val yx = queue.removeFirst()
        var step = cache[yx.first][yx.second]
        var yx_next = listOf(
            Pair(yx.first - 1, yx.second),
            Pair(yx.first + 1, yx.second),
            Pair(yx.first, yx.second - 1),
            Pair(yx.first, yx.second + 1)
        )
        for (nyx in yx_next) {
            var y = nyx.first
            var x = nyx.second
            if (y < 0 || x< 0 || x >= W || y >= H) { continue }
            if (s[y][x] == '#') { continue }
            if (x == W - 1 && y == H - 1) {
                println(whiteSum - step - 2)
                return
            }
            if (cache[y][x] == 0) {
                cache[y][x] = step + 1
                queue.addLast(Pair(y, x))
            }
        }
    }
    println(-1)
    return
}


fun main(args: Array<String>) {
    fun StringArray(size: Int, init: (Int) -> String = { "\u0000" }): Array<String> {
        return Array<String>(size, init)
    }
    val (H, W) = readLine()!!.split(' ').map{ it.toInt() }
    val s = Array(H){ readLine()!! }
    solve(H, W, s)
}

