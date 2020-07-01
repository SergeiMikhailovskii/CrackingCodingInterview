package com.mikhailovskii.task1_5

import java.lang.Math.abs
import java.lang.Math.max
import kotlin.random.Random

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

    fun allSequences(node: Node?): ArrayList<ArrayList<Int>> {
        val result = ArrayList<ArrayList<Int>>()

        if (node == null) {
            result.add(ArrayList())
            return result
        }

        val prefix = ArrayList<Int>()
        prefix.add(node.value)

        val leftSeq = allSequences(node.left)
        val rightSeq = allSequences(node.right)

        leftSeq.forEach { left ->
            rightSeq.forEach { right ->
                val weaved = ArrayList<ArrayList<Int>>()
                weaveLists(left, right, weaved, prefix)
                result.addAll(weaved)
            }
        }

        return result

    }

    private fun weaveLists(left: ArrayList<Int>, right: ArrayList<Int>, weaved: ArrayList<ArrayList<Int>>, prefix: ArrayList<Int>) {
        if (left.size == 0 || right.size == 0) {
            val result = prefix.clone() as ArrayList<Int>
            result.addAll(left)
            result.addAll(right)
            weaved.addAll(listOf(result))
            return
        }

        val headFirst = left.removeAt(0)
        prefix.add(headFirst)
        weaveLists(left, right, weaved, prefix)
        prefix.remove(prefix.size - 1)
        left.add(0, headFirst)

        val headSecond = right.removeAt(0)
        prefix.add(headSecond)
        weaveLists(left, right, weaved, prefix)
        prefix.remove(prefix.size - 1)
        right.add(0, headSecond)
    }

    fun getRandomNode(): Int {
        val depth = getTreeDepth()
        var currentNode = root

        for (i in 0..depth) {
            val choice = Random(System.nanoTime()).nextInt(0, 2)
            currentNode = if (choice == 0) {
                if (currentNode?.left == null) {
                    return currentNode!!.value
                } else {
                    currentNode.left
                }
            } else {
                if (currentNode?.right == null) {
                    return currentNode!!.value
                } else {
                    currentNode.right
                }
            }
        }
        return currentNode!!.value
    }

    companion object {

        fun containsTree(firstTree: Node?, secondTree: Node?): Boolean {
            val firstString = StringBuilder()
            val secondString = StringBuilder()

            getOrderString(firstTree, firstString)
            getOrderString(secondTree, secondString)

            return firstString.indexOf(secondString.toString()) != -1
        }

        private fun getOrderString(node: Node?, stringBuilder: StringBuilder) {
            if (node == null) {
                stringBuilder.append("X ")
                return
            }
            stringBuilder.append(node.value).append(" ")
            getOrderString(node.left, stringBuilder)
            getOrderString(node.right, stringBuilder)
        }

    }

}

class Node(val value: Int) {

    var left: Node? = null
    var right: Node? = null

}

fun main() {
    for (i in 0..10) {
        val tree = BinaryTree()
        tree.add(5)
        tree.add(3)
        tree.add(2)
        tree.add(4)
        tree.add(7)
        tree.add(6)
        tree.add(8)

        val value = tree.getRandomNode()
        println(value)
    }
}