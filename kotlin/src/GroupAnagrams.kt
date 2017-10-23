import java.util.*

/**
 * 49. Group Anagrams
 * Group Anagrams
 */
class GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val ans = ArrayList<ArrayList<String>>()
        val strGroupMap = HashMap<String, Int>()
        for (str in strs) {
            val chars = str.toCharArray()
            if (chars.isNotEmpty())
                quickSort(chars, 0, chars.size - 1)
            val sorted = chars.fold("") { s, c -> s + c }
            val index = strGroupMap.getOrPut(sorted) { strGroupMap.size }
            if (index >= ans.size)
                ans.add(arrayListOf(str))
            else
                ans[index].add(str)
        }
        return ans
    }

    private fun quickSort(chars: CharArray, first: Int, end: Int) {
        var i = first
        var k = end
        val mid = chars[k]
        while (i < k) {
            while (chars[i] <= mid && i < k)
                ++i
            if (i < k)
                chars[k] = chars[i]
            while (chars[k] >= mid && i < k)
                --k
            if (i < k)
                chars[i] = chars[k]
            chars[k] = mid
        }
        if (k > first)
            quickSort(chars, first, k - 1)
        if (k < end)
            quickSort(chars, k + 1, end)
    }
}

