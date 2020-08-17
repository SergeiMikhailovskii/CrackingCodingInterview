package com.mikhailovskii.task1_5

import kotlin.math.min

fun main() {
}

fun findElement(matrix: Array<Array<Int>>, origin: Coordinate, dest: Coordinate, x: Int): Coordinate? {
    if (!origin.inBounds(matrix) || !dest.inBounds(matrix)) {
        return null
    }
    if (matrix[origin.row][origin.column] == x) {
        return origin
    } else if (!origin.isBefore(dest)) {
        return null
    }

    val start = origin.clone()
    val diagDist = min(dest.row - origin.row, dest.column - origin.column)
    val end = Coordinate(start.row + diagDist, start.column + diagDist)
    val p = Coordinate(0, 0)

    while (start.isBefore(end)) {
        p.setToAverage(start, end)

        if (x > matrix[p.row][p.column]) {
            start.row = p.row + 1
            start.column = p.column + 1
        } else {
            end.row = p.row - 1
            end.column = p.column - 1
        }
    }

    return partitionAndSearch(matrix, origin, dest, start, x)

}

fun partitionAndSearch(matrix: Array<Array<Int>>, origin: Coordinate, dest: Coordinate, start: Coordinate, x: Int): Coordinate? {
    val lowerLeftOrigin = Coordinate(start.row, origin.column)
    val lowerLeftDest = Coordinate(dest.row, start.column - 1)
    val upperRightOrigin = Coordinate(origin.row, start.column - 1)
    val upperRightDest = Coordinate(start.row - 1, dest.column - 1)

    return findElement(matrix, lowerLeftOrigin, lowerLeftDest, x)
            ?: return findElement(matrix, upperRightOrigin, upperRightDest, x)
}

fun findElement(matrix: Array<Array<Int>>, x: Int): Coordinate? {
    val origin = Coordinate(0, 0)
    val dest = Coordinate(matrix.size - 1, matrix[0].size - 1)

    return findElement(matrix, origin, dest, x)
}

class Coordinate(var row: Int, var column: Int) {

    fun inBounds(matrix: Array<Array<Int>>): Boolean = row >= 0 && column >= 0 && row < matrix.size && column < matrix[0].size

    fun isBefore(dest: Coordinate): Boolean = row <= dest.row && column <= dest.column

    fun clone(): Coordinate = Coordinate(row, column)

    fun setToAverage(start: Coordinate, end: Coordinate) {
        row = (start.row + end.row) / 2
        column = (start.column + end.column) / 2
    }

}
