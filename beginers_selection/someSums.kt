fun main(args: Array<String>){
    val (n, a, b) = readLine()!!.split(" ").map{ it.toInt() }
    var ans = 0
    for (i in 1..n){
        var s = digitSum(i)
        if ( (a <= s) and (s <= b)){
            ans += i
        }
    }
    println(ans)
}


fun digitSum(num: Int):Int{
    var n = num
    var sum = 0
    while (n >= 1){
        sum += n % 10
        n /= 10
    }
    return sum
}
