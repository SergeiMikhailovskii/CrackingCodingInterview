package com.mikhailovskii.task1_5

import java.util.*

class Graph {
    val nodes = arrayListOf<Project>()
    private val map = hashMapOf<String, Project>()

    fun getOrCreateNode(name: String): Project? {
        if (!map.containsKey(name)) {
            val node = Project(name)
            nodes.add(node)
            map[name] = node
        }

        return map[name]
    }

    fun addEdge(startName: String, endName: String) {
        val start = getOrCreateNode(startName)
        val end = getOrCreateNode(endName)
        start?.addNeighbour(end!!)
    }
}

class Project(private val name: String) {
    val children = arrayListOf<Project>()
    var dependencies = 0

    private val map = hashMapOf<String, Project>()

    fun addNeighbour(node: Project) {
        if (!map.containsKey(node.name)) {
            children.add(node)
            map[node.name] = node
            node.incrementDependencies()
        }
    }

    private fun incrementDependencies() {
        dependencies++
    }

    fun decrementDependencies() {
        dependencies--
    }

}

fun findBuildOrder(projects: Array<String>, dependencies: Array<Array<String>>): Array<Project?>? {
    val graph = buildGraph(projects, dependencies)
    return orderProjects(graph.nodes)
}

fun orderProjects(projects: ArrayList<Project>): Array<Project?>? {
    val order = Array<Project?>(projects.size) { null }

    var endOfList = addNonDependent(order, projects, 0)
    var toBeProcessed = 0

    while (toBeProcessed < order.size) {
        val current = order[toBeProcessed] ?: return null

        val children = current.children

        children.forEach {
            it.decrementDependencies()
        }

        endOfList = addNonDependent(order, children, endOfList)
        toBeProcessed++

    }

    return order
}

fun addNonDependent(order: Array<Project?>, projects: ArrayList<Project>, _offset: Int): Int {
    var offset = _offset
    projects.forEach {
        if (it.dependencies == 0) {
            order[offset] = it
            offset++
        }
    }
    return offset
}

fun buildGraph(projects: Array<String>, dependencies: Array<Array<String>>): Graph {
    val graph = Graph()

    for (project in projects) {
        graph.getOrCreateNode(project)
    }

    for (dependency in dependencies) {
        val first = dependency[0]
        val second = dependency[1]
        graph.addEdge(first, second)
    }

    return graph
}
