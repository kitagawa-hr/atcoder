fun main(args: Array<String>){
  val a = readLine()!!.toInt() // 500
  val b = readLine()!!.toInt() // 100
  val c = readLine()!!.toInt() // 50
  val x = readLine()!!.toInt()
  var ans = 0
  for (i in 0..a){
      for (j in 0..b){
          for (k in 0..c){
              if (500*i+100*j+50*k == x){
                  ans += 1
              }
          }
      }
  }
  println(ans)
}
