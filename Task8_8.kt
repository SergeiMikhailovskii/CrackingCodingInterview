package com.mikhailovskii.task1_5

fun main() {
    val perms = printPerms("aabbcc")
    perms.forEach { println(it) }
}

fun printPerms(s: String): ArrayList<String> {
    val result = arrayListOf<String>()
    val map = buildFreqTable(s)
    printPerms(map, "", s.length, result)
    return result
}

fun printPerms(map: HashMap<Char, Int?>, prefix: String, remaining: Int, result: ArrayList<String>) {
    if (remaining == 0) {
        result.add(prefix)
        return
    }

    map.keys.forEach {
        val count = map[it]

        if (count != null) {
            if (count > 0) {
                map[it] = count - 1
                printPerms(map, prefix + it, remaining - 1, result)
                map[it] = count
            }

        }
    }
}

fun buildFreqTable(s: String): HashMap<Char, Int?> {
    val map = hashMapOf<Char, Int?>()
    s.forEach {
        if (!map.containsKey(it)) {
            map[it] = 0
        }
        map[it] = map[it]?.plus(1)
    }
    return map
}

