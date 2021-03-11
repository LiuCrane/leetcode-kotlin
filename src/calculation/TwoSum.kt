package calculation

class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        var map = mutableMapOf<Int, Int>()
        nums.forEachIndexed { i, num ->
            val another: Int = target - num
            if (map.containsKey(another)) return intArrayOf(map[another]!!, i) else map[num] = i
        }
        return intArrayOf()
    }
}