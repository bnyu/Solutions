/**
 * 3. Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters.
 */
class LongestSubstringWithoutRepeatingCharacters {
    fun lengthOfLongestSubstring_0(s: String): Int {
        if (s.isEmpty())
            return 0
        val sLen = s.length
        if (sLen == 1)
            return 1
        var maxLen = 1
        val dupCharIndex = HashMap<Char, MutableList<Int>>()
        val characters = HashSet<Char>()
        val dupCharSet = HashSet<Char>()
        val dupCharMap = HashMap<Int, Char>()
        //找出每个重复字符
        for (c in s) {
            if (characters.contains(c)) {
                if (!dupCharSet.contains(c))
                    dupCharSet.add(c)
            } else characters.add(c)
        }
        if (dupCharSet.isEmpty())
            return sLen
        //分别记录重复字符位置
        for (i in 0 until sLen) {
            val c = s[i]
            if (dupCharSet.contains(c)) {
                //key:位置 valve:字符
                dupCharMap.put(i, c)
                //key:字符 valve:所有位置
                if (dupCharIndex.containsKey(c))
                    dupCharIndex[c]?.add(i)
                else {
                    val list = ArrayList<Int>()
                    //首
                    list.add(-1)
                    list.add(i)
                    dupCharIndex.put(c, list)
                }
            }
        }
        val dupMap = HashMap<Char, Int>()
        //循环所有重复字符
        for (indexes in dupCharIndex.values) {
            //尾
            indexes.add(sLen - 1)
            val indexLength = indexes.size
            //判断3个重复字符之间是否还有其他重复字符
            var i = 0
            while (i < indexLength - 1) {
                val leftIndex = indexes[i]
                val midIndex = indexes[i + 1]
                var rightIndex = if (i + 2 == indexLength) midIndex else indexes[i + 2]
                //重复位置
                var dupIndex = leftIndex
                if (rightIndex - leftIndex > maxLen) {
                    var hasOtherDup = false
                    for (index in leftIndex + 1..rightIndex) {
                        val dupChar = dupCharMap[index]
                        if (dupChar != null) {
                            if (dupMap.containsKey(dupChar)) {
                                rightIndex = index
                                hasOtherDup = true
                                dupIndex = dupMap[dupChar]!!
                                break
                            } else
                                dupMap[dupChar] = index
                        }
                    }
                    dupMap.clear()
                    val needRemove = if (hasOtherDup) 1 else 0
                    val len = rightIndex - leftIndex - needRemove
                    if (len > maxLen) {
                        maxLen = len
                        //最长
                        if (maxLen >= characters.size)
                            return maxLen
                    }
                }
                //重复在下一个右侧 跳过下一个
                i = if (dupIndex > midIndex) i + 2 else i + 1
            }
        }
        return maxLen
    }

    //看不懂之前咋写那么复杂
    fun lengthOfLongestSubstring(s: String): Int {
        var max = 0
        if (!s.isEmpty()) {
            var start = -1 //只需要一直记录两个重复的位置 不断往右移
            var end = 0
            val dupMap = HashMap<Char, Int>()
            for (i in s.indices) {
                val dupIndex = dupMap[s[i]]
                if (dupIndex != null) { //3种情况
                    if (dupIndex < start) {
                        val len = i - start
                        max = if (len > max) len else max
                    } else if (dupIndex in start..end) {
                        val len = i - dupIndex
                        val len0 = i - 1 - start
                        max = if (len > max) len else max
                        max = if (len0 > max) len0 else max
                        start = dupIndex
                    } else if (dupIndex > end) {
                        val len = i - 1 - start
                        max = if (len > max) len else max
                        start = dupIndex
                    }
                    end = i
                }
                dupMap[s[i]] = i
            }
            val len = s.length - 1 - start
            max = if (len > max) len else max
        }
        return max
    }
}

// a  b  a  b
// b  a  a  b
// a  a  b  b