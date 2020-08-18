package com.mikhailovskii.task1_5

var root: RankNode? = null

fun main() {

}

fun track(number: Int) {
    if (root == null) {
        root = RankNode(number)
    } else {
        root?.insert(number)
    }
}

fun getRankOfNumber(number: Int): Int? = root?.getRank(number)

class RankNode(private var data: Int) {

    private var leftSize = 0
    private var left: RankNode? = null
    private var right: RankNode? = null

    fun insert(d: Int) {
        if (d <= data) {
            if (left != null) {
                left?.insert(d)
            } else {
                left = RankNode(d)
                leftSize++
            }
        } else {
            if (right != null) {
                right?.insert(d)
            } else {
                right = RankNode(d)
            }
        }
    }

    fun getRank(d: Int): Int {
        return when {
            d == data -> {
                leftSize
            }
            d < data -> {
                return if (left == null) {
                    -1
                } else {
                    left?.getRank(d) ?: 0
                }
            }
            else -> {
                val rightRank = if (right == null) -1 else right?.getRank(d)
                return if (rightRank == -1) -1 else leftSize + 1 + (rightRank ?: 0)
            }
        }
    }

}
