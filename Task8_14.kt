package com.mikhailovskii.task1_5

fun main() {
    println(countEval("1^0|0|1", false))
    println(countEval("0&0&0&1^1|0", true))
}

fun countEval(s: String, result: Boolean): Int {
    if (s.isEmpty()) return 0
    if (s.length == 1) return if (stringToBool(s) == result) 1 else 0

    var ways = 0
    for (i in 1 until s.length step 2) {
        val c = s[i]

        val left = s.substring(0, i)
        val right = s.substring(i + 1, s.length)

        val leftTrue = countEval(left, true)
        val leftFalse = countEval(left, false)
        val rightTrue = countEval(right, true)
        val rightFalse = countEval(right, false)

        val total = (leftTrue + leftFalse) * (rightTrue + rightFalse)

        var totalTrue = 0

        when (c) {
            '^' -> {
                totalTrue = leftTrue * rightFalse + leftFalse * rightTrue
            }
            '&' -> {
                totalTrue = leftTrue * rightTrue
            }
            '|' -> {
                totalTrue = leftTrue * rightTrue + leftFalse * rightTrue + leftTrue * rightFalse
            }
        }

        val subWays = if (result) totalTrue else total - totalTrue
        ways += subWays

    }

    return ways
}

fun stringToBool(c: String) = c == "1"