package com.mikhailovskii.task1_5

var variantsAmount = 0

fun main() {
    val length = 4
    findAllVariants(length)
    println(variantsAmount)
}

fun findAllVariants(length: Int) {
    when {
        length > 3 -> {
            variantsAmount += 3
            findAllVariants(length - 3)
            findAllVariants(length - 2)
            findAllVariants(length - 1)
        }
        length > 2 -> {
            variantsAmount += 2
            findAllVariants(length - 2)
            findAllVariants(length - 1)
        }
        length > 1 -> {
            variantsAmount++
        }
    }
}