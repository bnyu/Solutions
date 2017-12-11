/**
 * 10. Regular Expression Matching
 * Implement regular expression matching with support for '.' and '*'.
 */
class Solution010 {
    // 星号匹配的字符串 包括点字符
    private val starMap = HashMap<Int, String>()
    // 单个比配的字符串 包括点字符
    private val charMap = HashMap<Int, String>()
    private var ans = false
    private val star = '*'
    // 表示任意字符与结尾字符
    private val dot = '.'

    fun isMatch(s: String, p: String): Boolean {
        val length = p.length
        var index: Int
        // 匹配先后顺序
        var count = 0
        var i = 0
        while (i < length) {
            var j = 0
            // 多个连续星号 以最后一个星号开始作为标识符
            while (i + j + 1 < length) {
                if (star == p[i + j + 1])
                    j++
                else break
            }
            index = i + j
            if (j == 0) {
                // 连续字符串
                if (charMap.containsKey(count)) {
                    val cs = charMap[count] + p[index]
                    charMap.put(count, cs)
                } else {
                    count++
                    charMap.put(count, p[index].toString())
                }
            } else {
                var k = if (j % 2 == 0) j - 1 else j
                while (k > 0) {
                    if (starMap.containsKey(count)) {
                        val c = p[index - k]
                        var ss: String
                        if (dot == c)
                            ss = c.toString()
                        else {
                            ss = starMap[count]!!
                            // 连续不相同星号匹配
                            val c1 = ss[ss.length - 1]
                            if (c1 != c && c1 != dot)
                                ss += c
                        }
                        starMap.put(count, ss)
                    } else {
                        count++
                        starMap.put(count, p[index - k].toString())
                    }
                    k -= 2
                }
            }
            i = index + 1
        }
        if (s.isEmpty())
            return charMap.isEmpty()
        else if (p.isEmpty())
            return false

        val indexes = ArrayList<Int>()
        indexes.add(0)
        match(s, 0, 1, indexes)
        return ans
    }


    private fun match(s: String, startIndex: Int, step: Int, indexes: List<Int>?) {
        if (ans)
            return
        val length = s.length
        val count = starMap.size + charMap.size
        //星号匹配与字符串匹配一定是交替的
        if (charMap.containsKey(step)) {
            val cs = charMap[step]!!
            if (indexes != null && !indexes.isEmpty()) {
                val nextStep = step + 1
                for (i in indexes) {
                    val index = startIndex + i
                    if (charMatch(s, cs, index)) {
                        val nextStartIndex = index + cs.length
                        match(s, nextStartIndex, nextStep, null)
                    }
                }
            }
        } else if (starMap.containsKey(step)) {
            val ss = starMap[step]!!
            val endWith = if (step == count) dot else charMap[step + 1]!![0]
            val nextStep = step + 1
            match(s, startIndex, nextStep, starMatch(s, ss, startIndex, endWith))
        } else {
            // 匹配完所有部分 判断是否匹配
            if (indexes != null && !indexes.isEmpty()) {
                for (i in indexes) {
                    if (startIndex + i >= length) {
                        ans = true
                        return
                    }
                }
            } else
                ans = startIndex >= length
        }
    }


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


    private fun starMatch(s: String, ss: String, index: Int, endWith: Char): List<Int> {
        val length = ss.length
        //第一个是任意字符 即只有一个字符且是任意字符
        val isDot = ss[0] == dot
        if (isDot) {
            //可能匹配的长度
            val indexes = ArrayList<Int>()
            for (x in index..s.length) {
                val c = if (x == s.length) dot else s[x]
                // 则只考虑下一个char匹配就行
                if (c == endWith || dot == endWith)
                    indexes.add(x - index)
            }
            return indexes
        } else {
            //能匹配的最长长度
            var x = index
            for (i in 0 until length) {
                while (x < s.length) {
                    val c = s[x]
                    if (c != ss[i])
                        break
                    x++
                }
                if (x == s.length)
                    break
            }
            val indexes = ArrayList<Int>()
            for (i in index..x) {
                val c = if (i == s.length) dot else s[i]
                if (c == endWith || dot == endWith)
                    indexes.add(i - index)
            }
            if (indexes.isEmpty())
                indexes.add(0)
            return indexes
        }
    }

}

