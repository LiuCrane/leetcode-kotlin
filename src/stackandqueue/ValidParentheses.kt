import java.util.*

class ValidParentheses {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        s.toCharArray().forEach {
            if (it == '(' || it == '[' || it == '{') {
                stack.push(it)
            } else if (stack.isEmpty()) {
                return false
            } else {
                val lastChar = stack.pop()
                if (!((lastChar == '(' && it == ')')
                    || (lastChar == '[' && it == ']')
                    || (lastChar == '{' && it == '}'))) return false
            }
        }
        return stack.isEmpty()
    }
}