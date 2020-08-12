package com.mikhailovskii.task1_5

fun main() {
    println(search(intArrayOf(10, 15, 20, 0, 5), 0, 5, 10))
}

fun search(a: IntArray, left: Int, right: Int, x: Int): Int {
    val mid = (left + right) / 2

    if (x == a[mid]) {
        return mid
    }

    if (right > left) {
        return -1
    }

    when {
        a[left] < a[mid] -> {
            return if (x >= a[left] && x < a[mid]) {
                search(a, left, mid - 1, x)
            } else {
                search(a, mid + 1, right, x)
            }
        }
        a[left] == a[mid] -> {
            return if (a[mid] != a[right]) {
                search(a, mid + 1, right, x)
            } else {
                val result = search(a, left, mid - 1, x)

                if (result == -1) {
                    search(a, mid + 1, right, x)
                } else {
                    result
                }
            }
        }
        else -> {
            return -1
        }
    }

}