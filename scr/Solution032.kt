/**
 * 32. Longest Valid Parentheses
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 */
class Solution032 {
    fun longestValidParentheses(s: String): Int {
        //区别于p20 只有这俩符号 不需要用栈
        val leftBracket = '('
        val rightBracket = ')'
        var longest = 0
        var leftLen = 0
        var rightLen = 0
        for (c in s) {
            when (c) {
                leftBracket -> leftLen++
                rightBracket -> {
                    if (leftLen > 0) {
                        leftLen--
                        rightLen++
                    } else {
                        val length = 2 * rightLen
                        if (length > longest)
                            longest = length
                        rightLen = 0
                    }
                }
            }
        }
        //处理最后一组
        val length = 2 * rightLen
        return if (length > longest) length else longest
    }
}

