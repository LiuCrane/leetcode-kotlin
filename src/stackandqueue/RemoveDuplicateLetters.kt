package stackandqueue

class RemoveDuplicateLetters {
    fun removeDuplicateLetters(s: String): String {
        val result = StringBuilder()
        val strArray = s.toCharArray()
        val showingChars = BooleanArray(26)
        val leftCharNums = IntArray(26)
        strArray.forEach { leftCharNums[it - 'a'] += 1 } // count numbers for each char.
        strArray.forEach {
            if (!showingChars[it - 'a']) {
                while (result.isNotEmpty() && result[result.lastIndex] > it) { // left char greater than current char
                    val charToDelete = result[result.lastIndex]
                    if (leftCharNums[charToDelete - 'a'] > 0) { // there are still same char pending, so remove left char
                        result.deleteCharAt(result.lastIndex)
                        showingChars[charToDelete - 'a'] = false
                    } else {
                        break
                    }
                }
                showingChars[it - 'a'] = true
                result.append(it)
            }
            leftCharNums[it - 'a'] -= 1 // if exists already, just throw this char
        }
        return result.toString()
    }
}