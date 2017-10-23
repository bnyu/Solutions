//https://gist.github.com/bnyu/71955111eaf753aee4d113c9d7c68735
// Accepted

/**
 * 14. Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
class Solution014 {
    public String longestCommonPrefix(String[] strs) {
        String ans = "";
        if (strs.length >= 1) {
            String refer = strs[0];
            int common = 0;
            breakFor:
            for (int i = 0; i < refer.length(); i++) {
                for (String s : strs) {
                    if (i >= s.length())
                        break breakFor;
                    if (s.charAt(i) != refer.charAt(i))
                        break breakFor;
                }
                common++;
            }
            if (common > 0)
                ans = refer.substring(0, common);
        }
        return ans;
    }
}

