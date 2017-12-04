/**
 * 3. Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters.
 */
class LongestSubstringWithoutRepeatingCharacters {
    fun lengthOfLongestSubstring(s: String): Int {
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
                        if (dupCharMap.containsKey(index)) {
                            //Kotlin似乎暂时还没有不允许放入空元素的集合
                            val dupChar = dupCharMap[index]!!
                            if (dupMap.containsKey(dupChar)) {
                                rightIndex = index
                                hasOtherDup = true
                                dupIndex = dupMap[dupChar]!!
                                break
                            } else
                                dupMap.put(dupChar, index)
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
}

