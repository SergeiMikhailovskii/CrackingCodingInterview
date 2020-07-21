package com.mikhailovskii.task1_5

fun main() {


}

class Point(row: Int, col: Int)

fun getPath(maze: ArrayList<ArrayList<Boolean>>?): ArrayList<Point>? {
    val path = ArrayList<Point>()

    return when {
        maze.isNullOrEmpty() -> {
            null
        }
        getPath(maze, maze.size - 1, maze[0].size - 1, path) -> {
            path
        }
        else -> {
            null
        }
    }

}

fun getPath(maze: ArrayList<ArrayList<Boolean>>, row: Int, col: Int, path: ArrayList<Point>?): Boolean {
    val isAtOrigin = (row == 0) && (col == 0)
    return if (col < 0 || row < 0 || maze[row][col]) {
        false
    } else if (isAtOrigin || getPath(maze, row, col - 1, path) || getPath(maze, row - 1, col, path)) {
        val p = Point(row, col)
        path?.add(p)
        true
    } else {
        false
    }
}
