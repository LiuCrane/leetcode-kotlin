package arrayandpointer

import kotlin.math.max

class LongestNoRepeatSubString {
    fun lengthOfLongestSubstring(s: String): Int {
        var left = 0
        var right = 0
        var maxLength = 0
        if (s.isEmpty()) return maxLength
        while (right <= s.lastIndex) {
            if (left == right) {
                maxLength = max(1, maxLength)
                right++
                continue
            }
            if (s[left] != s[right]) {
                maxLength = max(right - left + 1, maxLength)
                println("right = $right, left = $left, maxLength = $maxLength")
                right++
            } else {
                left++
            }
        }
        return maxLength
    } }