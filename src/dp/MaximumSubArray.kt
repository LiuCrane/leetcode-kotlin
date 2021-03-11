package dp

import kotlin.math.max

class MaximumSubArray {
    fun maxSubArray(nums: IntArray): Int {
        val dp = arrayOfNulls<Int>(nums.size)
        var res = nums[0]
        dp[0] = res
        for (i in 1 .. nums.lastIndex) {
            dp[i] = if (dp[i - 1]!! > 0) dp[i -1]!! + nums[i] else nums[i]
            println("current index $i, ${dp[i]}")
            res = max(res, dp[i]!!)
        }
        return res
    }
}