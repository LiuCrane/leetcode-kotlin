//         i               i               i           i              i
//         j                 j              j              j              j
//[1,0,3,5,0,12] -> [1,0,3,5,0,12] ->[1,0,3,0,5,12] ->[1,0,0,3,5,12] ->[0,0,1,3,5,12]
class MoveZeros {
    fun moveZeroes(nums: IntArray) {
        var i = 0 // fast index, search non-zero element
        var j = 0 // slow index, point to element to be swap
        while (i < nums.size) {
            if (nums[i] != 0) {
                nums[j] = nums[i]
                j++
            }
            i++
        }
        while (j >=0) {
            nums[j] = 0
            j++
        }
    }

    private fun swap(nums: IntArray, searchIndex: Int, swapIndex: Int) {
        val temp = nums[searchIndex]
        nums[searchIndex] = nums[swapIndex]
        nums[swapIndex] = temp
    }

    fun moveZeroesReverse(nums: IntArray) {
        var i = nums.lastIndex // fast index, search non-zero element
        var j = nums.lastIndex // slow index, point to element to be swap
        while (i >= 0) {
            if (nums[i] != 0) {
                swap(nums, i, j)
                j--
            }
            i--
        }
        println(nums.contentToString())
    }
}