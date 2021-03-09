class FindMedianSortedArrays {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val nums = mergeTwoArrays(nums1, nums2)
        return if (nums.size % 2 != 0) {
            nums[nums.size / 2].toDouble()
        } else {
            (nums[(nums.size / 2)] + nums[(nums.size / 2) - 1]).toDouble() / 2
        }
    }

    private fun mergeTwoArrays(nums1: IntArray, nums2: IntArray): IntArray {
        val result = IntArray(nums1.size + nums2.size)
        var start1 = 0
        var start2 = 0
        var mergedIndex = 0
        while (start1 < nums1.size && start2 < nums2.size) {
            result[mergedIndex++] = if (nums1[start1] < nums2[start2]) nums1[start1++] else nums2[start2++]
        }
        while (start1 < nums1.size) {
            result[mergedIndex++] = nums1[start1++]
        }
        while (start2 < nums2.size) {
            result[mergedIndex++] = nums2[start2++]
        }
        println(result.contentToString())
        return result
    }
}