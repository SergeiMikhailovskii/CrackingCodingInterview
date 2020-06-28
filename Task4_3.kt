package com.mikhailovskii.task1_5

import kotlin.math.max

fun main() {
    val binaryTree = BinaryTree()

    binaryTree.add(8)
    binaryTree.add(4)
    binaryTree.add(12)
    binaryTree.add(2)
    binaryTree.add(6)
    binaryTree.add(1)
    binaryTree.add(3)

    var arrayOfValues = ArrayList<ArrayList<Int>>().apply {
        for (i in 0..binaryTree.getTreeDepth()) {
            this.add(ArrayList())
        }
    }

    arrayOfValues = binaryTree.addElementsForEachDepth(arrayOfValues)

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

    fun getTreeDepth(): Int = getTreeDepthRecursive(root, 0) - 1

    private fun getTreeDepthRecursive(node: Node?, _depth: Int): Int {
        var depth = _depth
        return if (node == null) {
            depth
        } else {
            depth++
            max(getTreeDepthRecursive(node.left, depth), getTreeDepthRecursive(node.right, depth))
        }
    }

    fun addElementsForEachDepth(arrayOfElements: ArrayList<ArrayList<Int>>): ArrayList<ArrayList<Int>> = addElementsForEachDepthRecursive(root, 0, arrayOfElements)

    private fun addElementsForEachDepthRecursive(node: Node?, _depth: Int, _arrayOfElements: ArrayList<ArrayList<Int>>): ArrayList<ArrayList<Int>> {
        var depth = _depth
        var arrayOfElements = _arrayOfElements

        if (node == null) {
            return arrayOfElements
        } else {
            arrayOfElements[depth].add(node.value)
            depth++
            arrayOfElements = addElementsForEachDepthRecursive(node.left, depth, arrayOfElements)
            arrayOfElements = addElementsForEachDepthRecursive(node.right, depth, arrayOfElements)
        }

        return arrayOfElements
    }

}