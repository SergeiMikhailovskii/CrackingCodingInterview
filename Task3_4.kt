package com.mikhailovskii.task1_5

open class BaseStack {
    private var head: MyStackData? = null

    open fun push(element: MyStackData) {
        element.next = head
        head = element
    }

    open fun pop(): MyStackData {
        if (head != null) {
            val element = head
            head = head?.next
            return element!!
        } else {
            throw Exception("Empty stack")
        }
    }

    open fun peek(): MyStackData? = head

    fun showAllElements() {
        var it = head

        while (it != null) {
            println(it.value)
            it = it.next
        }
    }

    fun getCurrentSize(): Int {
        var it = head
        var size = 0

        while (it != null) {
            it = it.next
            size++
        }

        return size
    }

    fun isEmpty(): Boolean = head == null

}

class MyStackData(val value: Int) {
    var next: MyStackData? = null
}

class MyQueue : BaseStack() {
    private val firstStack = BaseStack()
    private val secondStack = BaseStack()

    override fun push(element: MyStackData) {
        firstStack.push(element)
    }

    override fun pop(): MyStackData {
        while (!firstStack.isEmpty()) {
            secondStack.push(firstStack.pop())
        }

        val pop = secondStack.pop()

        while (!secondStack.isEmpty()) {
            firstStack.push(secondStack.pop())
        }

        return pop
    }

    override fun peek(): MyStackData? {
        while (!firstStack.isEmpty()) {
            secondStack.push(firstStack.pop())
        }

        val pop = secondStack.peek()

        while (!secondStack.isEmpty()) {
            firstStack.push(secondStack.pop())
        }

        return pop
    }

}


fun main() {
    val myQueue = MyQueue()

    myQueue.push(MyStackData(1))
    myQueue.push(MyStackData(2))
    myQueue.push(MyStackData(3))
    myQueue.push(MyStackData(4))
    myQueue.push(MyStackData(5))

    println(myQueue.peek()?.value)

    println(myQueue.pop().value)
    println(myQueue.pop().value)

}

