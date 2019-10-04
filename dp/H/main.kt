import java.io.*
import java.util.*

const val MOD = 1000000007L
fun solve(H: Int, W: Int, a: Array<String>) {
    val dp = Array(H) { LongArray(W) }
    for (i in H - 1 downTo 0) {
        for (j in W - 1 downTo 0) {
            if (a[i][j] == '#') continue
            dp[i][j] = when {
                i == H - 1 && j == W - 1 -> 1
                i == H - 1 -> dp[i][j + 1]
                j == W - 1 -> dp[i + 1][j]
                else -> (dp[i + 1][j] + dp[i][j + 1]) % MOD
            }
        }
    }
    // for(i in 0 until H){
    //     for (j in 0 until W){
    //         print(dp[i][j])
    //     }
    //     println()
    // }
    println(dp[0][0])
    return
}

fun main(args: Array<String>) {
    val (H, W) = readLine()!!.split(" ").map { it.toInt() }
    val a = Array(H) { readLine()!! }
    solve(H, W, a)
}
