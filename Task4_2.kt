package com.mikhailovskii.task1_5

fun main() {
    val binaryTree = BinaryTree()

    val node = binaryTree.createMinimalBst(arrayOf(1, 2, 3, 4, 5, 6, 7))

    binaryTree.setRootNode(node)

    println()
}

class Node(val value: Int) {

    var left: Node? = null
    var right: Node? = null

}

class BinaryTree {

    var root: Node? = null

    private fun addRecursive(current: Node?, value: Int): Node {
        if (current == null) {
            return Node(value)
        }

        when {
            value < current.value -> {
                current.left = addRecursive(current.left, value)
            }
            value > current.value -> {
                current.right = addRecursive(current.right, value)
            }
            else -> {
                return current
            }
        }

        return current

    }

    fun add(value: Int) {
        root = addRecursive(root, value)
    }

    fun setRootNode(node: Node?) {
        root = node
    }

    fun createMinimalBst(values: Array<Int>): Node? = createMinimalBst(values, 0, values.size - 1)

    private fun createMinimalBst(values: Array<Int>, start: Int, end: Int): Node? {
        if (end < start) {
            return null
        }

        val mid = (end + start) / 2
        val node = Node(values[mid])
        node.left = createMinimalBst(values, start, mid - 1)
        node.right = createMinimalBst(values, mid + 1, end)

        return node

    }

}