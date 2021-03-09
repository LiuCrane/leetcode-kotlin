class TopKFrequentElements {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val result = mutableListOf<Int>()
        var numbersLeft = k
        val numWithFrequency = mutableMapOf<Int, Int>() // key as number, value as frequency
        nums.forEach {
            val oldFrequency = numWithFrequency[it] ?: 0
            numWithFrequency[it] = oldFrequency + 1
        }
        val buckets = Array<MutableList<Int>>(nums.size + 1) { mutableListOf() }
        numWithFrequency.entries.forEach { buckets[it.value].add(it.key) }
        for (i in buckets.lastIndex downTo 1) {
            if (buckets[i].size <= numbersLeft) {
                result.addAll(buckets[i])
                numbersLeft -= buckets[i].size
                if (numbersLeft <= 0) break
            } else {
                result.addAll(buckets[i].subList(0, numbersLeft - 1))
                break
            }
        }
        return result.toIntArray()
    }
}