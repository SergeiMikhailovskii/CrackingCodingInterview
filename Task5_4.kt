package com.mikhailovskii.task1_5

fun main() {
    val number = 0b1010
    println(Integer.toBinaryString(getNext(number)))
    println(Integer.toBinaryString(getPrev(number)))
}

fun getNext(_n: Int): Int {
    var n = _n
    var c = n
    var onePosition = 0
    var zeroPosition = 0

    val p: Int

    while (c.and(1) == 0 && c != 0) {
        onePosition++
        c = c.ushr(1)
    }

    while (c.and(1) == 1) {
        zeroPosition++
        c = c.ushr(1)
    }

    p = zeroPosition + onePosition

    n = n.or((1).shl(p))
    n = n.and(((1).shl(p) - 1).inv())
    n = n.or((1).shl(zeroPosition - 1)) - 1

    return n
}

fun getPrev(_n: Int): Int {
    var n = _n
    var temp = _n
    var c0 = 0
    var c1 = 0

    val p: Int
    val mask: Int

    while (temp.and(1) == 1) {
        c1++
        temp = temp.ushr(1)
    }

    if (temp == 0) return -1

    while ((temp.and(1) == 0) && (temp != 0)) {
        c0++
        temp = temp.ushr(1)
    }

    p = c0 + c1

    n = n.and((0).inv().shl(p + 1))
    mask = (1).shl(c1 + 1) - 1
    n = n.or(mask.shl(c0 - 1))

    return n
}