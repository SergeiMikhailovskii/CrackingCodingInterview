package com.mikhailovskii.task1_5

fun main() {
    println(printBinary(0.5))
}

fun printBinary(_num: Double): String {
    var num = _num

    if (num <= 0 || num >= 1) {
        return "Error"
    }

    val builder = StringBuilder()

    while (num > 0) {
        if (builder.length >= 32) {
            return "Error"
        }

        num *= 2

        if (num >= 1) {
            num -= 1
            builder.append(1)
        } else {
            builder.append(0)
        }
    }

    return builder.toString()

}


