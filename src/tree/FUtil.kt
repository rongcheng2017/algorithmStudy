package tree


fun swap(array: IntArray, a: Int, b: Int) {
    if (a >= array.size || a < 0) {
        throw ArrayIndexOutOfBoundsException("first param a out of index")
    }

    if (b >= array.size || b < 0) {
        throw ArrayIndexOutOfBoundsException("second param a out of index")
    }
    if (a == b) {
        return
    }
    val temp = array[a]
    array[a] = array[b]
    array[b] = temp
}


fun swap(array: ArrayList<Int>, a: Int, b: Int) {
    if (a >= array.size || a < 0) {
        throw ArrayIndexOutOfBoundsException("first param a out of index")
    }

    if (b >= array.size || b < 0) {
        throw ArrayIndexOutOfBoundsException("second param a out of index")
    }
    if (a == b) {
        return
    }
    val temp = array[a]
    array[a] = array[b]
    array[b] = temp
}