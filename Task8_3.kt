package com.mikhailovskii.task1_5

fun main() {
    val array = arrayOf(7, 6, 5, 4, 3, 2, 1, 0)

    val index = findMagicIndex(array)
    println(index)
}

fun findMagicIndex(array: Array<Int>): Int? {
    if (array.size == 1) {
        return null
    }
    val middleIndex = array.size / 2
    return when {
        array[middleIndex] == middleIndex -> {
            middleIndex
        }
        array[middleIndex] < middleIndex -> {
            findMagicIndex(array.copyOfRange(0, middleIndex))
        }
        else -> {
            findMagicIndex(array.copyOfRange(middleIndex, array.size - 1))
        }
    }
}

