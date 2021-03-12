package sort

class SortColors {
    fun sortColors(nums: IntArray): Unit {
        nums.forEach {
            when (it) {
                0 -> READ_LIST.add(it)
                1 -> GREEN_LIST.add(it)
                2 -> BLUE_LIST.add(it)
            }
        }
        val result = mutableListOf<Int>()
        result.apply {
            addAll(READ_LIST)
            addAll(GREEN_LIST)
            addAll(BLUE_LIST)
        }
        for (i in nums.indices) {
            nums[i] = result[i]
        }
    }

    companion object {
        val READ_LIST = mutableListOf<Int>()
        val GREEN_LIST = mutableListOf<Int>()
        val BLUE_LIST = mutableListOf<Int>()
    }
}