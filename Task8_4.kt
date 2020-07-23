package com.mikhailovskii.task1_5

import kotlin.math.pow

fun main() {
    findAllSubLists(arrayListOf(1, 2, 3, 4, 5, 6, 7))
}

fun findAllSubLists(elements: MutableList<Int>) {
    val length = elements.size

    for (i in 0 until 2.toDouble().pow(length.toDouble()).toInt()) {
        print("{")

        for (j in 0 until length) {
            if ((i and (1.shl(j))) != 0) {
                print("${elements[j]} ")
            }
        }
        println("}")
    }
}

