import java.util.Stack

/**
 * 20. Valid Parentheses
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
class Solution020 {
    fun isValid(s: String): Boolean {
        val brackets = mutableMapOf(Pair('(', ')'), Pair('[', ']'), Pair('{', '}'))
        val toMatch = Stack<Char>()
        for (i in 0 until s.length) {
            val c = s[i]
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

