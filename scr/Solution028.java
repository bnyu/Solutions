package p28;
//https://gist.github.com/bnyu/7a8160d3521d5c9d22892caf91ddc226
// Accepted

/**
 * 28. Implement strStr()
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length())
            return -1;
        else if (needle.length() == 0)
            return 0;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j))
                    break;
                if (j == needle.length() - 1)
                    return i;
            }
        }
        return -1;
    }
}

