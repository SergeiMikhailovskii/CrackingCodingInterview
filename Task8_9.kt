package com.mikhailovskii.task1_5

fun main() {
    val n = 3
    val str = CharArray(2 * n)
    printParenthesis(str, n)
}

fun printParenthesis(str: CharArray, n: Int) {
    if (n > 0) printParenthesis(str, 0, n, 0, 0)
    return
}

private fun printParenthesis(str: CharArray, pos: Int, n: Int, open: Int, close: Int) {
    if (close == n) {
        for (i in str.indices) print(str[i])
        println()
        return
    } else {
        if (open > close) {
            str[pos] = '}'
            printParenthesis(str, pos + 1, n, open, close + 1)
        }
        if (open < n) {
            str[pos] = '{'
            printParenthesis(str, pos + 1, n, open + 1, close)
        }
    }
}
