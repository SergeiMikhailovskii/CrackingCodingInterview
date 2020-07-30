package com.mikhailovskii.task1_5

import java.util.*
import kotlin.math.max

fun main() {
    val height = createStack(arrayListOf(
            Box(3, 3, 3),
            Box(2, 2, 4),
            Box(4, 4, 1)
    ))

    println(height)
}

fun createStack(boxes: ArrayList<Box>): Int {
    Collections.sort(boxes, BoxComparator())

    val stackMap = Array(boxes.size) { 0 }

    return createStack(boxes, null, 0, stackMap)
}

fun createStack(boxes: ArrayList<Box>, bottom: Box?, offset: Int, stackMap: Array<Int>): Int {
    if (offset >= boxes.size) {
        return 0
    }

    val newBottom = boxes[offset]
    var heightWithBottom = 0

    if (bottom == null || newBottom.canBeAbove(bottom)) {
        if (stackMap[offset] == 0) {
            stackMap[offset] = createStack(boxes, newBottom, offset + 1, stackMap)
            stackMap[offset] += newBottom.z
        }

        heightWithBottom = stackMap[offset]
    }

    val heightWithoutBottom = createStack(boxes, bottom, offset + 1, stackMap)

    return max(heightWithBottom, heightWithoutBottom)
}

data class Box(val x: Int, val y: Int, val z: Int) {
    fun canBeAbove(bottom: Box): Boolean = bottom.x > this.x && bottom.y > this.y
}

class BoxComparator : Comparator<Box> {

    override fun compare(o1: Box, o2: Box): Int = o1.z - o2.z

}