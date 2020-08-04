package com.mikhailovskii.task1_5

fun main() {
}

fun findPathBiBFS(people: HashMap<Int, Person>, source: Int, destination: Int): ArrayList<Person?>? {
    val sourceData = BFSData(people[source])
    val destData = BFSData(people[destination])

    while (!sourceData.isFinished() && !destData.isFinished()) {
        val collision = searchLevel(people, sourceData, destData)

        if (collision != null) {
            return mergePaths(sourceData, destData, collision.id)
        }
    }

    return null
}

fun mergePaths(bfs1: BFSData, bfs2: BFSData, connection: Int): ArrayList<Person?>? {
    val end1 = bfs1.visited[connection]
    val end2 = bfs2.visited[connection]

    val pathOne = end1?.collapse(false)
    val pathTwo = end2?.collapse(true)

    pathTwo?.removeAt(0)
    pathTwo?.let {
        pathOne?.addAll(it)
    }

    return pathOne
}

fun searchLevel(people: HashMap<Int, Person>, primary: BFSData, secondary: BFSData): Person? {
    val count = primary.toVisit.size

    for (i in 0..count) {
        val pathNode = primary.toVisit.removeAt(0)
        val personId = pathNode.person?.id

        if (secondary.visited.containsKey(personId)) {
            return pathNode.person
        }

        val person = pathNode.person
        val friends = person?.friends

        friends?.forEach {
            if (!primary.visited.containsKey(it)) {
                val friend = people[it]
                val next = PathNode(friend, pathNode)
                primary.visited[it] = next
                primary.toVisit.add(next)
            }
        }
    }

    return null
}

data class Person(var id: Int, var friends: ArrayList<Int>)

class BFSData(root: Person?) {

    val toVisit = ArrayList<PathNode>()
    val visited = HashMap<Int?, PathNode>()

    init {
        val sourcePath = PathNode(root, null)
        toVisit.add(sourcePath)
        visited[root?.id] = sourcePath
    }

    fun isFinished(): Boolean = toVisit.isEmpty()

}

class PathNode(var person: Person?, var previous: PathNode?) {

    fun collapse(startsWithRoot: Boolean): ArrayList<Person?> {
        val path = ArrayList<Person?>()
        var node: PathNode? = this

        while (node != null) {
            if (startsWithRoot) {
                path.add(node.person)
            } else {
                path.add(0, node.person)
            }

            node = node.previous
        }

        return path

    }

}