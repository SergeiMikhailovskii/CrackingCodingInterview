package com.mikhailovskii.task1_5

fun main() {
    val perms = getPerms("abcd")

    perms.forEach {
        println(it)
    }
}

fun getPerms(str: String): ArrayList<String> {
    val result = arrayListOf<String>()
    getPerms("", str, result)
    return result
}

fun getPerms(prefix: String, remainder: String, result: ArrayList<String>) {
    if (remainder.isEmpty()) {
        result.add(prefix)
    }

    val length = remainder.length

    for (i in 0 until length) {
        val before = remainder.substring(0, i)
        val after = remainder.substring(i + 1, length)
        val c = remainder[i]
        getPerms(prefix + c, before + after, result)
    }

}