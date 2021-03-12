package dp

import kotlin.math.max

class LongestPalindromicSubsequence {
    fun longestPalindromeSubseq(s: String): Int {
        val strArray = s.toCharArray()
        val dp: Array<IntArray> = initDp(s.length)
        for (i in s.lastIndex downTo 0) { // 从数组最下方往上遍历，最终填上 dp[0][s.lastIndex] 也就是s的最长子序列长度
            for (j in i + 1 .. s.lastIndex) {
                dp[i][j] = if (strArray[i] == strArray[j]) { // 状态转移方程
                    dp[i + 1][j - 1] + 2
                } else {
                    max(dp[i + 1][j], dp[i][j - 1])
                }
            }
        }
        return dp[0][s.lastIndex] // s[0]到s[lastIndex]的最长子序列
    }

    private fun initDp(size: Int): Array<IntArray> {
        val result = Array(size) { IntArray(size)}
        for (i in 0 until size) result[i][i] = 1
        return result
    }
}