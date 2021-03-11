package search

class LetterCombinations {
    private val outputLetters = mutableListOf<String>()
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return outputLetters
        val digitsArray = digits.toCharArray()
        dfs(digitsArray, 0, "")
        return outputLetters
    }

    private fun dfs(digitsArray: CharArray, i: Int, string: String) {
        if (i > digitsArray.lastIndex) {
            outputLetters.add(string)
            return
        }
        val number = digitsArray[i]
        LETTER_MAP[number.toString().toInt()]?.forEach {
            val newString = string + it
            dfs(digitsArray, i + 1, newString)
        } ?: dfs(digitsArray, i + 1, string)
    }

    companion object {
        private val TWO = charArrayOf('a', 'b', 'c')
        private val THREE = charArrayOf('d', 'e', 'f')
        private val FOUR = charArrayOf('g', 'h', 'i')
        private val FIVE = charArrayOf('j', 'k', 'l')
        private val SIX = charArrayOf('m', 'n', 'o')
        private val SEVEN = charArrayOf('p', 'q', 'r', 's')
        private val EIGHT = charArrayOf('t', 'u', 'v')
        private val NINE = charArrayOf('w', 'x', 'y', 'z')
        private val LETTER_MAP = arrayOf(null, null, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE)
    }
}