package com.mikhailovskii.task1_5

import kotlin.math.abs

const val GRID_SIZE = 8

fun main() {

}

fun placeQueens(row: Int, columns: Array<Int>, results: ArrayList<Array<Int>>) {
    if (row == GRID_SIZE) {
        results.add(columns.clone())
    } else {
        for (col in 0 until GRID_SIZE) {
            if (checkValid(columns, row, col)) {
                columns[row] = col
                placeQueens(row + 1, columns, results)
            }
        }
    }
}

fun checkValid(columns: Array<Int>, row1: Int, col1: Int): Boolean {
    for (row2 in 0 until row1) {
        val column2 = columns[row2]

        if (col1 == column2) {
            return false
        }

        val columnDistance = abs(column2 - col1)

        val rowDistance = row1 - row2
        if (columnDistance == rowDistance) {
            return false
        }
    }

    return true
}
