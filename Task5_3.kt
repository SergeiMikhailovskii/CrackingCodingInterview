package com.mikhailovskii.task1_5

import kotlin.math.max

fun main() {
    var number = 0b1101110111
    val numbers = arrayListOf<Int>()
    var previousSymbol: Int

    if (number.and(1) == 1) {
        previousSymbol = 1
        numbers.add(0)
    } else {
        previousSymbol = 0
    }
    var counter = 0

    while (number != 0) {
        val lastNumber = number.shl(31).ushr(31)
        number = number.ushr(1)
        if (lastNumber != previousSymbol) {
            previousSymbol = lastNumber
            numbers.add(counter)
            counter = 0
        }
        counter++
    }
    numbers.add(counter)

    var maxSeq = 1

    for (i in 0 until numbers.size step 2) {
        val zeroElement = numbers[i]

        val previousElement = if (i - 1 >= 0) numbers[i - 1] else 0
        val nextElement = if (i + 1 < numbers.size) numbers[i + 1] else 0

        var sum = 0

        when {
            zeroElement == 1 -> {
                sum = previousElement + zeroElement + nextElement
            }
            zeroElement > 1 -> {
                sum = 1 + max(previousElement, nextElement)
            }
            zeroElement == 0 -> {
                sum = max(previousElement, nextElement)
            }
        }

        maxSeq = max(sum, maxSeq)
    }

    println(maxSeq)
}


