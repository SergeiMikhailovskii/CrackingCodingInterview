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
    var setOfStacks = ArrayList<BaseStack>()

    val maxCapacity = 3

    setOfStacks = pushElement(MyStackData(1), setOfStacks, maxCapacity)
    setOfStacks = pushElement(MyStackData(2), setOfStacks, maxCapacity)
    setOfStacks = pushElement(MyStackData(3), setOfStacks, maxCapacity)
    setOfStacks = pushElement(MyStackData(4), setOfStacks, maxCapacity)
    setOfStacks = pushElement(MyStackData(5), setOfStacks, maxCapacity)
    setOfStacks = pushElement(MyStackData(6), setOfStacks, maxCapacity)
    setOfStacks = pushElement(MyStackData(7), setOfStacks, maxCapacity)
    setOfStacks = pushElement(MyStackData(8), setOfStacks, maxCapacity)

    setOfStacks = removeFromStack(setOfStacks)
    setOfStacks = removeFromStack(setOfStacks, 1)

}

fun showAllStacks(stacks: ArrayList<BaseStack>) {
    stacks.forEach {
        it.showAllElements()
    }
}

fun pushElement(element: MyStackData, setOfStack: ArrayList<BaseStack>, maxCapacity: Int): ArrayList<BaseStack> {
    var isEmptySpace = false
    for (i in setOfStack) {
        if (i.getCurrentSize() < maxCapacity) {
            i.push(element)
            isEmptySpace = true
            break
        }
    }
    if (!isEmptySpace) {
        val stack = BaseStack()
        stack.push(element)
        setOfStack.add(stack)
    }
    return setOfStack
}

fun removeFromStack(setOfStack: ArrayList<BaseStack>): ArrayList<BaseStack> {
    setOfStack[setOfStack.size - 1].pop()
    return setOfStack
}

fun removeFromStack(setOfStack: ArrayList<BaseStack>, position: Int): ArrayList<BaseStack> {
    setOfStack[position].pop()
    return setOfStack
}