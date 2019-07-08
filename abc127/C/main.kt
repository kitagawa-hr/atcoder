import java.io.PrintWriter

import java.io.BufferedInputStream

// Generated by 1.1.4 https://github.com/kyuridenamida/atcoder-tools  (tips: You use the default template now. You can remove this line by using your custom template)
fun main(args: Array<String>) {
    fun iterateTokens(): Iterator<String> {
        val reader = BufferedInputStream(System.`in`).bufferedReader()
        val it = reader.lineSequence()
                .map { it.split(" ") }
                .reduce { left, right -> left + right }
                .iterator()
        return it
    }
    val tokens = iterateTokens()
    val N = tokens.next().toLong()
    val M = tokens.next().toLong()
    val L = LongArray(M.toInt())
    val R = LongArray(M.toInt())
    for (i in 0 until M.toInt()) {
        L[i] = tokens.next().toLong()
        R[i] = tokens.next().toLong()
    }
    solve(N, M, L, R)
}

fun solve(N: Long, M: Long, L: LongArray, R: LongArray) {
    val diff = R.min()!! - L.max()!!
    val pw = PrintWriter(System.out)
    if (diff < 0) {
        pw.println("0")
    } else {
        pw.println(diff + 1)
        }
    pw.flush()
}
