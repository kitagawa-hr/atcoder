
fun main(args: Array<String>){
    val n = readLine()!!.toInt()
    var T = IntArray(n+1)
    var X = IntArray(n+1)
    var Y = IntArray(n+1)
    T[0] = 0
    X[0]=0
    Y[0]=0
    for (i in 1..n){
        val (t, x, y) = readLine()!!.split(" ").map{ it.toInt() }
        T[i] = t
        X[i] = x
        Y[i] = y
    }
    for (j in 1..n){
        if (!canTravel(T[j]-T[j-1], X[j-1], Y[j-1], X[j], Y[j])){
            println("No")
            return
        }
    }
    println("Yes")
    return

}

fun canTravel(t: Int, x1:Int, y1:Int, x2:Int, y2:Int):Boolean{
    var distance = abs(x2 - x1) + abs(y2 - y1)
    return (t-distance >= 0) and (((t - distance) % 2) == 0)
}
fun abs(x: Int):Int{
    return if (x>0) x else -x
}
