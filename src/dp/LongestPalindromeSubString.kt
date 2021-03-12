package dp

class LongestPalindromeSubString {
    fun longestPalindrome(s: String): String {
        var maxLength = 1
        var beginIndex = 0
        val strArray = s.toCharArray()
        val dp = Array(s.length) { BooleanArray(s.length) }
        for (i in s.lastIndex downTo 0) { // 从下往上，从左往右遍历
            for (j in i .. s.lastIndex) {
                dp[i][j] = strArray[i] == strArray[j]
                if (j - i >= 3) dp[i][j] = dp[i][j] && dp[i + 1][j - 1]
                val tempLength = j - i + 1
                if (dp[i][j] && tempLength > maxLength) { //在状态转移方程内部实时更新最大值
                    beginIndex = i
                    maxLength = tempLength
                }
            }
        }
        return s.substring(beginIndex, beginIndex + maxLength)
    }
}