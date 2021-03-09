class SortCharactoersByFrequency {
    fun frequencySort(s: String): String {
        val result = StringBuilder()
        val charFrequency = mutableMapOf<Char, Int>()
        s.forEach {
            if (charFrequency[it] == null) charFrequency[it] = 1 else charFrequency[it] = charFrequency[it]!! + 1
        }
        val buckets = Array<MutableList<String>>(s.length + 1) { mutableListOf() }
        charFrequency.entries.forEach {
            var temp = ""
            for (i in 1 .. it.value) temp += it.key
            buckets[it.value].add(temp)
        }
        for (i in buckets.lastIndex downTo 1) {
            buckets[i].forEach {
                result.append(it)
            }
        }
        return result.toString()
    }
}