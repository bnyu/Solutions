/**
 * 6. ZigZag Conversion
 */
class Solution006 {
    fun convert(s: String, numRows: Int): String {
        val ans: String
        if (!s.isEmpty() && numRows > 0) {
            if (numRows == 1)
                return s
            val length = s.length
            val chars = CharArray(length)
            var lIndex: Int
            var rIndex: Int
            var count = 0
            val column = (length - 1) / (numRows - 1) / 2 + 1
            for (j in 0 until numRows) {
                for (i in 0..column) {
                    val index = 2 * i * (numRows - 1)
                    lIndex = index - j
                    rIndex = index + j
                    if (splice(chars, lIndex, length, count, s))
                        count++
                    if (j != 0 && j != numRows - 1)
                        if (splice(chars, rIndex, length, count, s))
                            count++
                }
            }
            ans = String(chars)
        } else
            ans = ""
        return ans
    }

    private fun splice(chars: CharArray, index: Int, length: Int, count: Int, s: String): Boolean {
        if (index in 0 until length) {
            chars[count] = s[index]
            return true
        }
        return false
    }
}

