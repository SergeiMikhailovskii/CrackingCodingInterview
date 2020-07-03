package com.mikhailovskii.task1_5

import kotlin.math.pow

fun main() {
    val n = 0b10000000000
    val m = 0b10011
    val i = 2
    val j = 6

    val shifted = n.shr(j + 1).shl(j - i + 1).or(m).shl(i).or(n.and(2.0.pow(i).toInt() - 1))
    println(shifted)
}
