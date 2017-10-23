package p6;
//https://gist.github.com/bnyu/ded31f2eb23dc6a32967f10fe392273f
// Accepted

/**
 * 6. ZigZag Conversion
 */
class Solution {
    public String convert(String s, int numRows) {
        String ans;
        if (!s.isEmpty() && numRows > 0) {
            if (numRows == 1)
                return s;
            int length = s.length();
            char[] chars = new char[length];
            int lIndex;
            int rIndex;
            int count = 0;
            int column = (length - 1) / (numRows - 1) / 2 + 1;
            for (int j = 0; j <= numRows - 1; j++) {
                for (int i = 0; i <= column; i++) {
                    int index = 2 * i * (numRows - 1);
                    lIndex = index - j;
                    rIndex = index + j;
                    if (splice(chars, lIndex, length, count, s))
                        count++;
                    if (j != 0 && j != numRows - 1)
                        if (splice(chars, rIndex, length, count, s))
                            count++;
                }
            }
            ans = String.valueOf(chars);
        } else
            ans = "";
        return ans;
    }

    private boolean splice(char[] chars, int index, int length, int count, String s) {
        if (index >= 0 && index < length) {
            chars[count] = s.charAt(index);
            return true;
        }
        return false;
    }
}

