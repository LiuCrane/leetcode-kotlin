package arrayandpointer

class ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        nums.sort()
        var k = 0
        while (nums[k] <= 0 && k < nums.size - 2) {
            var i = k + 1
            var j = nums.lastIndex
            if (k > 0 && nums[k] == nums[k - 1]) {
                k++
                continue
            }
            while (i < j) {
                when {
                    nums[k] + nums[i] + nums[j] < 0 -> {
                        i++
                        while (i < j && nums[i - 1] == nums[i]) i++
                    }
                    nums[k] + nums[i] + nums[j] > 0 -> {
                        j--
                        while (i < j && nums[j + 1] == nums[j]) j--
                    }
                    else -> {
                        result.add(arrayListOf(nums[k], nums[i], nums[j]))
                        i++
                        j--
                        while (i < j && nums[i - 1] == nums[i]) i++
                        while (i < j && nums[j + 1] == nums[j]) j--
                    }
                }
            }
            k++
        }
        return result
    }
}