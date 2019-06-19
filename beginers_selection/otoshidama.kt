const val a1 = 1
const val a2 = 5
const val a3 = 10

fun main(args: Array<String>){
    val (n, y_) = readLine()!!.split(" ").map{ it.toInt() }
    var y = y_/1000
    for (b3 in 0..y/a3){
        for (b2 in 0..(y-b3*a3)/a2){
            var b1 = n - b2 - b3
            if (a1 * b1 + a2*b2 + a3*b3 == y){
                println("$b3 $b2 $b1")
                return
            }
        }
    }
    println("-1 -1 -1")
    return
}
