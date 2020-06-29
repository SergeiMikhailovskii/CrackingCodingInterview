package com.mikhailovskii.task1_5

import kotlin.math.abs
import kotlin.math.max

fun main() {
    val binaryTree = BinaryTree()

    binaryTree.root = Node(5)

    binaryTree.root?.left = Node(3)
    binaryTree.root?.right = Node(7)

    binaryTree.root?.left?.top = binaryTree.root
    binaryTree.root?.right?.top = binaryTree.root

    binaryTree.root?.left?.left = Node(2)
    binaryTree.root?.left?.left?.top = binaryTree.root?.left

    binaryTree.root?.left?.right = Node(4)
    binaryTree.root?.left?.right?.top = binaryTree.root?.left

    binaryTree.root?.right?.left = Node(6)
    binaryTree.root?.right?.left?.top = binaryTree.root?.right

    binaryTree.root?.right?.right = Node(8)
    binaryTree.root?.right?.right?.top = binaryTree.root?.right

    println(binaryTree.inOrderSuccess(binaryTree.root?.left?.right)?.value)


}

class Node(val value: Int) {

    var left: Node? = null
    var right: Node? = null
    var top: Node? = null

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

    fun isTreeBalanced(): Boolean = isTreeBalancedRecursive(root)

    private fun isTreeBalancedRecursive(node: Node?): Boolean {
        if (node == null) {
            return true
        }

        val leftHeight = getTreeDepthRecursive(node.left, 0)
        val rightHeight = getTreeDepthRecursive(node.right, 0)

        return abs(leftHeight - rightHeight) <= 1 && isTreeBalancedRecursive(node.left) && isTreeBalancedRecursive(node.right)
    }

    fun addLeft(value: Int) {
        root = addLeftRecursive(root, value)
    }

    private fun addLeftRecursive(node: Node?, value: Int): Node {
        if (node == null) {
            return Node(value)
        }
        node.left = addLeftRecursive(node.left, value)
        return node
    }

    fun addRight(value: Int) {
        root = addRightRecursive(root, value)
    }

    private fun addRightRecursive(node: Node?, value: Int): Node {
        if (node == null) {
            return Node(value)
        }
        node.right = addRightRecursive(node.right, value)
        return node
    }

    fun isBinarySearchTree(): Boolean {
        return isBinarySearchTreeRecursive(root, Int.MIN_VALUE, Int.MAX_VALUE) && areAllElementsUnique(root, hashSetOf())
    }

    private fun areAllElementsUnique(root: Node?, set: HashSet<Int>): Boolean {
        if (root == null) {
            return true
        }
        if (set.contains(root.value)) {
            return false
        } else if (areAllElementsUnique(root.left, set) && areAllElementsUnique(root.right, set)) {
            set.add(root.value)
            return true
        }
        return false
    }

    private fun isBinarySearchTreeRecursive(node: Node?, min: Int, max: Int): Boolean {
        if (node == null) {
            return true
        } else if (node.value < min || node.value > max) {
            return false
        }
        return isBinarySearchTreeRecursive(node.left, min, node.value - 1)
                && isBinarySearchTreeRecursive(node.right, node.value + 1, max)
    }

    fun inOrderSuccess(node: Node?): Node? {
        if (node == null) {
            return null
        }

        return if (node.right != null) {
            getLeftMostChild(node.right)
        } else {
            var q = node
            var x = q.top

            while (x != null && x.left != q) {
                q = x
                x = x.top
            }
            x
        }

    }

    private fun getLeftMostChild(_node: Node?): Node? {
        var node: Node? = _node ?: return null

        while (node?.left != null) {
            node = node.left
        }

        return node
    }

}