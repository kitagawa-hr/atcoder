@Suppress("UNUSED_PARAMETER")
fun main(args: Array<String>) {
    val (N, M) = readLine()!!.split(" ").map{ it.toLong() }
    var L = LongArray(M.toInt())
    var R = LongArray(M.toInt())
    for (i in 0 until M.toInt()){
        val (l, r) = readLine()!!.split(" ").map{ it.toLong() }
        L[i] = l
        R[i] = r
    }
    solve(N, M, L, R)
}


fun solve(N: Long, M: Long, L: LongArray, R: LongArray){
    val diff = R.min()!! - L.max()!!
    if (diff < 0){
        println("0")
    }else{
        println(diff+1)
        }
}