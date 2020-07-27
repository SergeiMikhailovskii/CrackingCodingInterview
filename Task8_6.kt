package com.mikhailovskii.task1_5

import java.util.*

fun main() {
    val n = 3

    val towers = arrayOf(
            Tower(),
            Tower(),
            Tower()
    )

    for (i in n - 1 downTo 0) {
        towers[0].add(i)
    }

    towers[0].moveDisks(n, towers[2], towers[1])

    println()
}

class Tower {
    private var disks: Stack<Int> = Stack()

    fun add(d: Int) {
        if (disks.isNotEmpty() && disks.peek() <= d) {
            println("Error placing disk $d")
        } else {
            disks.push(d)
        }
    }

    private fun moveTopTo(t: Tower) {
        val top = disks.pop()
        t.add(top)
    }

    fun moveDisks(n: Int, destination: Tower, buffer: Tower) {
        if (n > 0) {
            moveDisks(n - 1, buffer, destination)
            moveTopTo(destination)
            buffer.moveDisks(n - 1, destination, this)
        }
    }

}