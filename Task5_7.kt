package com.mikhailovskii.task1_5

fun main() {
    println(Integer.toBinaryString(pairwiseSwap(0b010101)))
}

fun pairwiseSwap(_number: Int): Int {
    var number = _number
    var newNumber = 0

    while (number != 0) {
        newNumber += if (number.ushr(1).and(1) == 1) {
            1
        } else {
            0
        }

        newNumber = newNumber.shl(1)

        newNumber += if (number.and(1) == 1) {
            1
        } else {
            0
        }

        newNumber = newNumber.shl(1)

        number = number.ushr(2)

    }

    return newNumber
}

