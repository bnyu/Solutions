/**
 * 14. Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
class Solution014 {
    fun longestCommonPrefix(strs: Array<String>): String {
        val ans = if (strs.isNotEmpty()) {
            val refer = strs[0]
            var common = 0
            breakFor@ for (i in 0 until refer.length) {
                for (s in strs) {
                    //超出最短
                    if (i >= s.length)
                        break@breakFor
                    //出现不一致
                    if (s[i] != refer[i])
                        break@breakFor
                }
                common++
            }
            if (common > 0) refer.substring(0, common) else ""
        } else ""
        return ans
    }
}

