fun main(args: Array<String>){
    val N = readLine()!!.toInt()
    val U = IntArray(N-1)
    val V = IntArray(N-1)
    val W = IntArray(N-1)
    for (i in 0 until N-1){
        val (u, v, w) = readLine()!!.split(" ")
        U[i] = u.toInt()
        V[i] = v.toInt()
        W[i] = (w.toLong() % 2L).toInt()
    }
    println(0)
    println(0)
    println(1)
}

class MergeSort() {
    fun <T : Comparable<T>> perform(arr: Array<T>) {
        val aux = arr.clone()
        sort(arr, aux, 0, arr.size - 1)
    }

    private fun <T : Comparable<T>> sort(arr: Array<T>, aux: Array<T>, lo: Int, hi: Int) {
        if (hi <= lo) return
        val mid = (lo + hi) / 2
        sort(arr, aux, lo, mid)
        sort(arr, aux, mid + 1, hi)
        merge(arr, aux, lo, mid, hi)
    }

    private fun <T : Comparable<T>> merge(arr: Array<T>, aux: Array<T>, lo: Int, mid: Int, hi: Int) {
        System.arraycopy(arr, lo, aux, lo, hi - lo + 1)

        var i = lo
        var j = mid + 1
        for (k in lo..hi) {
            when {
                i > mid -> arr[k] = aux[j++]
                j > hi -> arr[k] = aux[i++]
                aux[j] < aux[i] -> arr[k] = aux[j++]
                else -> arr[k] = aux[i++]
            }
        }
    }
}
