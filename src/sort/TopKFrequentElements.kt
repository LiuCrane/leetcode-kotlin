import java.util.*

class TopKFrequentElements {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        var leftSize = k
        val result = mutableListOf<Int>()
        val numFrequency = mutableMapOf<Int, Int>()
        nums.forEach {
            if (numFrequency.containsKey(it)) numFrequency[it] = numFrequency[it]!! + 1 else numFrequency[it] = 1
        }
        val bucket = Array(nums.size) { mutableListOf<Int>() } //array 的 下标即为频率， 里面的数组即为对应频率的数字。
        numFrequency.entries.forEach {
            bucket[it.value].add(it.key)
        }
        for (i in bucket.lastIndex .. 0) { // 倒序拿到频率最高的数 (每个频率可能包括不止一个数
            if (bucket[i].size < leftSize) {
                result.addAll(bucket[i])
                leftSize -= bucket[i].size
            } else result.addAll(bucket[i].subList(0, leftSize - 1))
        }
        return result.toIntArray()
    }
}