package com.mikhailovskii.task1_5

import java.lang.Math.abs
import java.lang.Math.max

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

    private fun covers(root: Node?, p: Node?): Boolean {
        if (root == null) return false
        if (root == p) return true
        return covers(root.left, p) || covers(root.right, p)
    }

    private fun ancestorHelper(root: Node?, p: Node?, q: Node?): Node? {
        if (root == null || root == p || root == q) return root
        val pIsOnLeft = covers(root.left, p)
        val qIsOnLeft = covers(root.left, q)

        if (pIsOnLeft != qIsOnLeft) {
            return root
        }

        val childSide = if (pIsOnLeft) root.left else root.right

        return ancestorHelper(childSide, p, q)
    }

    fun commonAncestor(root: Node?, p: Node?, q: Node?): Node? {
        if (!covers(root, p) || !covers(root, q)) return null
        return ancestorHelper(root, p, q)
    }

}

class Node(val value: Int) {

    var left: Node? = null
    var right: Node? = null

}

fun main() {
    val tree = BinaryTree()
    tree.add(20)
    tree.add(10)
    tree.add(30)
    tree.add(5)
    tree.add(15)
    tree.add(3)
    tree.add(7)
    tree.add(17)

    val common = tree.commonAncestor(tree.root, tree.root?.left?.left?.left, tree.root?.left?.right?.right)
    println()
}