/**
 * 44. Wildcard Matching
 * Implement wildcard pattern matching with support for '?' and '*'.
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * The function prototype should be: bool isMatch(const char *s, const char *p)
 * Some examples: isMatch("aa","a") → false, isMatch("aa", "*") → true, isMatch("aa", "a*") → true, isMatch("ab", "?*") → true
 */

class Solution044 {
    // 星号 charMap的key:匹配顺序
    private val starSet = HashSet<Int>()
    // 字符串匹配 包括'?'字符
    private val charMap = HashMap<Int, String>()
    private val star = '*'
    // 表示任意字符与结尾字符
    private val dot = '?'

    /**
     * 和p10有一点点区别, p10是匹配'*'号前字符任意长度; p44'*'号匹配任意字符任意长度
     */
    fun isMatch(s: String, p: String): Boolean {
        val length = p.length
        var index = 0
        // 匹配先后顺序
        var count = 0
        while (index < length) {
            count++
            index += when (star) {
                p[index] -> {
                    // 多个连续星号 等于一个星号
                    var i = 1
                    while (index + i < length) {
                        if (star == p[index + i])
                            i++
                        else break
                    }
                    starSet.add(count)
                    i
                }
                else -> {
                    // 连续字符串
                    var i = 1
                    while (index + i < length) {
                        if (star != p[index + i])
                            i++
                        else break
                    }
                    val str = p.substring(index, index + i)
                    charMap.put(count, str)
                    i
                }
            }
        }
        if (s.isEmpty())
            return charMap.isEmpty()
        else if (p.isEmpty())
            return false

        val indexes = arrayListOf(0)
        return match(s, 0, 1, indexes)
    }


    private fun match(s: String, startIndex: Int, step: Int, indexes: List<Int>): Boolean {
        val length = s.length
        val count = starSet.size + charMap.size
        //星号匹配与字符串匹配一定是交替的
        if (charMap.containsKey(step)) {
            val cs = charMap[step]!!
            if (!indexes.isEmpty()) {
                val nextStep = step + 1
                val nextIndexes = if (nextStep >= count) indexes else ArrayList(1)
                for (i in indexes) {
                    val index = startIndex + i
                    if (charMatch(s, cs, index)) {
                        val nextStartIndex = index + cs.length
                        //这里传indexes无影响 下次是starMatch 除非这是最后一项匹配
                        if (match(s, nextStartIndex, nextStep, nextIndexes))
                            return true
                    }
                }
            }
        } else if (starSet.contains(step)) {
            val endWith = if (step == count) dot else charMap[step + 1]?.get(0) ?: dot
            val nextStep = step + 1
            return match(s, startIndex, nextStep, starMatch(s, startIndex, endWith))
        } else {
            // 匹配完所有部分 判断是否匹配
            if (!indexes.isEmpty()) {
                for (i in indexes) {
                    if (startIndex + i >= length)
                        return true
                }
            } else return startIndex >= length
        }
        return false
    }

    //和p10一样
    private fun charMatch(s: String, cs: String, index: Int): Boolean {
        val length = cs.length
        if (index + length > s.length)
            return false
        for (i in 0 until length) {
            val c = cs[i]
            if (dot == c)
                continue
            if (s[index + i] != c)
                return false
        }
        return true
    }

    //这里和p10不同 仅需考虑之后下一个字符匹配
    private fun starMatch(s: String, index: Int, endWith: Char): List<Int> {
        //可能匹配的长度
        val indexes = ArrayList<Int>()
        for (x in index..s.length) {
            val c = if (x == s.length) dot else s[x]
            if (c == endWith || dot == endWith)
                indexes.add(x - index)
        }
        return indexes
    }

}

