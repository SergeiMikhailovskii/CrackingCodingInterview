package com.mikhailovskii.task1_5

import java.util.*

fun main() {
}

class AnagramComparator : Comparator<String> {

    private fun sortChars(s: String): String {
        val content = s.toCharArray()
        Arrays.sort(content)
        return String(content)
    }

    override fun compare(o1: String, o2: String): Int = sortChars(o1).compareTo(sortChars(o2))

}
