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

    fun peek(): MyStackData? = head

    fun showAllElements() {
        var it = head

        while (it != null) {
            println(it.value)
            it = it.next
        }
    }

    fun isEmpty(): Boolean = head == null

}

class MyStackData(val value: Int) {
    var next: MyStackData? = null
}

class ElementsStack : BaseStack() {
    private var minStack: BaseStack = BaseStack()

    override fun push(element: MyStackData) {
        super.push(element)

        if (minStack.isEmpty()) {
            minStack.push(element)
        } else {
            minStack.peek()?.let {
                if (element.value <= it.value) {
                    minStack.push(element)
                }
            }
        }

    }

    override fun pop(): MyStackData {
        val element = super.pop()
        if (element.value == minStack.peek()?.value) {
            minStack.pop()
        }
        return element
    }

    fun getMin() = minStack.peek()?.value
}

fun main() {
    val task32 = ElementsStack()

    task32.push(MyStackData(3))
    println(task32.getMin())

    task32.push(MyStackData(2))
    println(task32.getMin())

    task32.push(MyStackData(1))
    println(task32.getMin())

    task32.pop()
    println(task32.getMin())

}