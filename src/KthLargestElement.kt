import kotlin.math.min

class KthLargestElement {
    // 快速排序
    fun findKthLargest(nums: IntArray, k: Int): Int {
        var left = 0
        var right = nums.lastIndex
        while (true) {
            val middle = partition(nums, left, right)
            when {
                middle == k -> return nums[middle]
                middle > k -> right = middle - 1
                else -> left = middle + 1
            }
        }
    }

    private fun partition(nums: IntArray, left: Int, right: Int): Int {
        // use first left number as pivot point
        var highIndex = left
        var lowIndex = right
        val pivot = nums[left]
        while (highIndex < lowIndex) {
            while (nums[lowIndex] <= pivot &&  highIndex < lowIndex) lowIndex--
            while (nums[highIndex] >= pivot && highIndex < lowIndex) highIndex++
            swap(nums, highIndex, lowIndex)
        }
        swap(nums, 0, highIndex)
        return highIndex
    }

    private fun swap(nums: IntArray, left: Int, right: Int) {
        val swapNum = nums[left]
        nums[left] = nums[right]
        nums[right] = swapNum
    }
}