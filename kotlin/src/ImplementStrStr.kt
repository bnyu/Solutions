/**
 * 28. Implement strStr()
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
class ImplementStrStr {
    fun strStr(haystack: String, needle: String): Int {
        if (haystack.length < needle.length)
            return -1
        else if (needle.length == 0)
            return 0
        for (i in 0..haystack.length - needle.length) {
            for (j in 0 until needle.length) {
                if (haystack[i + j] != needle[j])
                    break
                if (j == needle.length - 1)
                    return i
            }
        }
        return -1
    }
}

