
fun main(args: Array<String>){
    val (N, K) = readLine()!!.split(" ").map{ it.toInt() }
    var ans = 0.toDouble()
    for (s in 1..minOf(N, K-1)){
        ans += Math.pow(1 / 2.toDouble(), powerOfTwo(s, K).toDouble())
    }
    if (N >= K){
        ans += N - K + 1
    }
    ans /= N
    println(ans)
}

fun powerOfTwo(s: Int, k:Int):Int{
    var score = s
    var power = 0
    while (score < k){
        score *= 2
        power += 1
    }
    return power
}

fun pow(num: Double, power: Int): Double{
    var n = num
    if (power == 0){ return 1.toDouble() }
    for (i in 0 until power - 1){
        n *= num
    }
    return n
}
fun <T : Comparable<T>> minOf(a: T, b: T): T = if (a<b) a else b
