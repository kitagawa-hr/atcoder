
fun main(args: Array<String>){
    val n = readLine()!!.toInt()
    val ds = IntArray(n){
        readLine()!!.toInt()
    }
    println(ds.distinct().size)
}
