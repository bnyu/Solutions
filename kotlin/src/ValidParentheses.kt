import java.util.Stack

/**
 * 20. Valid Parentheses
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
class ValidParentheses {
    fun isValid(s: String): Boolean {
        val brackets = mutableMapOf(Pair('(', ')'), Pair('[', ']'), Pair('{', '}'))
        val toMatch = Stack<Char>()
        for (c in s) {
            if (!brackets.containsKey(c) && !brackets.containsValue(c))
                continue
            //左括号 入栈
            if (brackets.containsKey(c))
                toMatch.push(brackets[c])
            else {
                //右括号 出栈
                if (toMatch.empty())
                    return false
                val match = toMatch.pop()
                if (match != c)
                    return false
            }
        }
        return toMatch.empty()
    }
}

