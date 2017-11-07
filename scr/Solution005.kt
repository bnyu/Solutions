/**
 * 5. Longest Palindromic Substring
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 */
class Solution005 {
    fun longestPalindrome(s: String): String {
        val ans: String
        if (!s.isEmpty()) {
            val chars = s.toCharArray()
            val length = chars.size
            var longest = 1
            var leftIndex = 0
            var rightIndex = 0
            for (i in 1 until length) {
                //以第i个为中心 往左往右依次对比
                var len = 1
                var j = 1
                while (i - j >= 0 && i + j < length) {
                    if (chars[i - j] != chars[i + j])
                        break
                    len += 2
                    j++
                }
                if (len > longest) {
                    leftIndex = i - len / 2
                    rightIndex = len
                    longest = len
                }
                //以第i个与第i-1个之间为中心
                len = 0
                j = 1
                while (i - j >= 0 && i + j - 1 < length) {
                    if (chars[i - j] != chars[i + j - 1])
                        break
                    len += 2
                    j++
                }
                if (len > longest) {
                    leftIndex = i - len / 2
                    rightIndex = len
                    longest = len
                }
            }
            ans = if (longest != 1) String(chars, leftIndex, rightIndex) else chars[0].toString()
        } else
            ans = ""
        return ans
    }
}

