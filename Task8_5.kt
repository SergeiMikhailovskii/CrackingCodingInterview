package com.mikhailovskii.task1_5

fun main() {
    println(minProduct(31, 30))
}

fun minProduct(a: Int, b: Int): Int {
    val bigger = if (a > b) a else b
    val smaller = if (a > b) b else a

    return minProductHelper(smaller, bigger)
}

fun minProductHelper(smaller: Int, bigger: Int): Int {
    if (smaller == 0) {
        return 0
    } else if (smaller == 1) {
        return bigger
    }

    val s = smaller.ushr(1)
    val halfProd = minProductHelper(s, bigger)

    return if (smaller % 2 == 0) {
        halfProd + halfProd
    } else {
        halfProd + halfProd + bigger
    }

}