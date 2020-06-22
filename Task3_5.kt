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


fun main() {

    var stack = BaseStack()
    stack.push(MyStackData(3))
    stack.push(MyStackData(1))
    stack.push(MyStackData(4))
    stack.push(MyStackData(5))
    stack.push(MyStackData(2))

    stack = sortStack(stack)

    stack.showAllElements()

}

fun sortStack(stack: BaseStack): BaseStack {
    val tempStack = BaseStack()

    while (!stack.isEmpty()) {
        val element = stack.pop()

        if (tempStack.isEmpty()) {
            tempStack.push(MyStackData(element.value))
        } else {
            while (tempStack.peek() != null && tempStack.peek()?.value!! > element.value) {
                stack.push(MyStackData(tempStack.pop().value))
            }
            tempStack.push(MyStackData(element.value))
        }

    }

    while (!tempStack.isEmpty()) {
        stack.push(tempStack.pop())
    }

    return stack

}

