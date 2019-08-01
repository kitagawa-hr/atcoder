import java.io.*
import java.util.*

val pw = PrintWriter(System.out)
fun solve(A: Int, B: Int){
    val size = 100
    pw.println("$size $size")
    val maze = Array(size){ y -> IntArray(size){ if(y < size/2) 0 else 1 } }
    var i = 0
    var j = 0
    repeat (A - 1){
        maze[i][j] = 1
        when(j){
            size - 2  -> { j = 0; i += 2 }
            else -> { j += 2 }
        }
    }
    i = size / 2 + 1
    j = 0
    repeat (B - 1){
        maze[i][j] = 0
        when(j){
            size - 2 -> { j = 0; i+= 2 }
            else -> { j += 2 }
        }
    }
    for (inner in maze){
        pw.println(inner.map{ if(it == 1) '.' else '#' }.joinToString(separator=""))
    }
    pw.flush()
    return
}


fun main(args: Array<String>) {
    fun StringArray(size: Int, init: (Int) -> String = { "\u0000" }): Array<String> {
        return Array<String>(size, init)
    }
    class Scanner(stream: InputStream) {
        private val reader = BufferedInputStream(stream).bufferedReader()
        private var st: StringTokenizer? = null
        fun next(): String {
            while (!(st?.hasMoreTokens() ?: false)) st = StringTokenizer(reader.readLine())
            return st!!.nextToken()
        }
    }
    val sc = Scanner(System.`in`)
    val A = sc.next().toInt()
    val B = sc.next().toInt()
    solve(A, B)
}
