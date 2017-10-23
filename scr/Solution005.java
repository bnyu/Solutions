package p5;
//https://gist.github.com/bnyu/a79f4548acfcaa99d4a3ac6b3f535e27
// Accepted

/**
 * 5. Longest Palindromic Substring
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 */
class Solution {
    public String longestPalindrome(String s) {
        String ans;
        if (!s.isEmpty()) {
            char[] chars = s.toCharArray();
            int length = chars.length;
            int longest = 1;
            ans = String.valueOf(chars[0]);
            for (int i = 1; i < length; i++) {
                int len = 1;
                for (int j = 1; i - j >= 0 && i + j < length; j++) {
                    if (chars[i - j] != chars[i + j])
                        break;
                    len += 2;
                }
                if (len > longest) {
                    ans = String.valueOf(chars, i - len / 2, len);
                    longest = len;
                }

                len = 0;
                for (int j = 1; i - j >= 0 && i + j - 1 < length; j++) {
                    if (chars[i - j] != chars[i + j - 1])
                        break;
                    len += 2;
                }
                if (len > longest) {
                    ans = String.valueOf(chars, i - len / 2, len);
                    longest = len;
                }
            }
        } else
            ans = "";
        return ans;
    }
}

