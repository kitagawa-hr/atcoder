fun main(args: Array<String>){
    val n = readLine()!!.toInt()
    val aList = readLine()!!.split(" ").map{ it.toInt() }.sortedBy{ -it }
    var ans = aList.slice(0..aList.size-1 step 2).sum() - aList.slice(1..aList.size-1 step 2).sum()
    println(ans)
}
