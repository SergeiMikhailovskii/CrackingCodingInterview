package com.mikhailovskii.task1_5

fun main() {
    val graph = Graph(7)
    graph.addEdge(0, 1)
    graph.addEdge(1, 2)
    graph.addEdge(2, 0)
    graph.addEdge(2, 3)
    graph.addEdge(3, 2)
    graph.addEdge(4, 6)
    graph.addEdge(5, 4)
    graph.addEdge(6, 5)

    println(graph.isReachable(3, 4))
    println(graph.isReachable(0, 3))
}

class Graph(private val vertices: Int) {

    private val adjacency: MutableList<MutableList<Int>> = mutableListOf()

    init {
        for (i in 0..vertices) {
            adjacency.add(mutableListOf())
        }
    }

    fun addEdge(start: Int, end: Int) {
        adjacency[start].add(end)
    }

    fun isReachable(start_: Int, end: Int): Boolean {
        var start = start_
        val visited = Array(vertices) { false }

        val queue = mutableListOf<Int>()

        visited[start] = true
        queue.add(start)

        while (queue.size != 0) {
            start = queue[0]
            queue.removeAt(0)

            adjacency[start].forEach {
                if (it == end) return true

                if (!visited[it]) {
                    visited[it] = true
                    queue.add(it)
                }

            }

        }

        return false

    }


}
