package com.mikhailovskii.task1_5

fun main() {
    println(countBitsNumberToFlip(0b10101, 0b01010))
}

fun countBitsNumberToFlip(first: Int, second: Int): Int {
    var max = if (first > second) first else second
    var min = if (first > second) second else first
    var count = 0

    while (max != 0) {
        if (max.and(1) != min.and(1)) {
            count++
        }
        max = max.ushr(1)
        min = min.ushr(1)
    }

    return count
}

