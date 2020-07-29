package com.mikhailovskii.task1_5

fun main() {
    println(makeChange(100))
}

fun makeChange(n: Int): Int {
    val values = arrayOf(25, 10, 5, 1)

    val map = Array(n + 1) { Array(values.size) { 0 } }

    return makeChange(n, values, 0, map)
}

fun makeChange(amount: Int, values: Array<Int>, index: Int, map: Array<Array<Int>>): Int {
    return when {
        map[amount][index] > 0 -> {
            map[amount][index]
        }
        index >= values.size - 1 -> {
            1
        }
        else -> {
            val valuesAmount = values[index]
            var ways = 0

            for (i in 0..amount / valuesAmount) {
                val amountRemaining = amount - i * valuesAmount
                ways += makeChange(amountRemaining, values, index + 1, map)
            }

            map[amount][index] = ways
            ways
        }
    }
}
