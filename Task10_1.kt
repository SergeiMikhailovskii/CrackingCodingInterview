package com.mikhailovskii.task1_5

fun main() {
    val result = merge(arrayOf(1, 2, 3, 0, 0, 0), arrayOf(4, 5, 6), 3, 3)
    println()
}

fun merge(a: Array<Int>, b: Array<Int>, lastA: Int, lastB: Int): Array<Int> {
    var indexA = lastA - 1
    var indexB = lastB - 1
    var indexMerged = lastB + lastA - 1

    while (indexB >= 0) {
        if (indexA >= 0 && a[indexA] > b[indexB]) {
            a[indexMerged] = a[indexA]
            indexA--
        } else {
            a[indexMerged] = b[indexB]
            indexB--
        }

        indexMerged--
    }

    return a

}
