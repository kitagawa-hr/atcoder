fun main(args: Array<String>){
    val T = arrayOf("dream", "dreamer", "erase", "eraser")
    val S = readLine()!!
    var i = S.length - 1
    var flag = 0
    while (i > 0){
        flag = 0
        for (t in T){
            if (S.slice(0..i).endsWith(t)){
                i -= t.length
                flag = 1
                continue
            }
        }
        if (flag == 0){
            println("NO")
            return
        }
    }
    println("YES")
    return
}
