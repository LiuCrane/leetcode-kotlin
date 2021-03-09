class QuickSort {
    fun sort(nums : IntArray): IntArray {
        quickSort(nums, 0, nums.lastIndex)
        println(nums.contentToString())
        return nums
    }

    private fun quickSort(nums: IntArray, start: Int, end: Int) {
        if (start < end) {
            val middle = partition(nums, start, end)
            quickSort(nums, start, middle - 1)
            quickSort(nums, middle + 1, end)
        }
    }

    private fun partition(nums: IntArray, start: Int, end: Int): Int {
        val pivot = nums[start]
        var partStart = start
        var partEnd = end
        while (partStart < partEnd) {
            while (nums[partEnd] <= pivot && partStart < partEnd) partEnd--
            while (nums[partStart] >= pivot && partStart < partEnd) partStart++
            swap(nums, partStart, partEnd)
        }
        swap(nums, start, partStart)
        return partStart // 此时start和end是一样的
    }

    private fun swap(nums: IntArray, partStart: Int, partEnd: Int) {
        val temp = nums[partStart]
        nums[partStart] = nums[partEnd]
        nums[partEnd] = temp
    }
}