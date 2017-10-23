/**
 * 32. Longest Valid Parentheses
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 */
class LongestValidParentheses {
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
                        //每次满足都比较一次 若仅最大满足比较 右边括号可能不足
                        if (leftLen == 0) {
                            if (rightLen > longest)
                                longest = rightLen
                        }
                    } else {
                        //从上一组最长情况结束开始 这一组也达到最长
                        if (rightLen > longest)
                            longest = rightLen
                        rightLen = 0
                    }
                }
            }
        }
        //反向判断
        leftLen = 0
        rightLen = 0
        for (i in (s.length - 1) downTo 0) {
            val c = s[i]
            when (c) {
                rightBracket -> rightLen++
                leftBracket -> {
                    if (rightLen > 0) {
                        rightLen--
                        leftLen++
                        if (leftLen == 0) {
                            if (rightLen > longest)
                                longest = rightLen
                        }
                    } else {
                        if (leftLen > longest)
                            longest = leftLen
                        leftLen = 0
                    }
                }
            }
        }
        return 2 * longest
    }
}

