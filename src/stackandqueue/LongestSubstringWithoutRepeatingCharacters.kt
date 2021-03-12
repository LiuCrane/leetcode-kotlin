package stackandqueue

import java.util.*
import kotlin.math.max

class LongestSubstringWithoutRepeatingCharacters {
    fun lengthOfLongestSubstring(s: String): Int {
        val result: Queue<Char> = LinkedList()
        var maxLength = 0
        s.toCharArray().forEach {
            while (result.contains(it)) { // 使用队列作为一个滑动窗口，当碰到重复的元素，则出队列直到不存在重复元素。
                result.poll()
            }
            result.add(it)
            maxLength = max(result.size, maxLength)
        }
        return maxLength
    }
}