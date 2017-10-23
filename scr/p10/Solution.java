package p10;
//https://gist.github.com/bnyu/edfb06d53c374af7ada23fcf44606e83
// Accepted

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 10. Regular Expression Matching
 * Implement regular expression matching with support for '.' and '*'.
 */
class Solution {
    // 星号匹配的字符串 包括点字符
    private final Map<Integer, String> starMap = new HashMap<>();
    // 单个比配的字符串 包括点字符
    private final Map<Integer, String> charMap = new HashMap<>();
    private boolean ans = false;
    private final char star = '*';
    // 表示任意字符与结尾字符
    private final char dot = '.';

    public boolean isMatch(String s, String p) {
        final int length = p.length();
        int index;
        // 匹配先后顺序
        int count = 0;
        for (int i = 0; i < length; ) {
            int j = 0;
            // 多个连续星号 以最后一个星号开始作为标识符
            while (i + j + 1 < length) {
                if (star == p.charAt(i + j + 1))
                    j++;
                else break;
            }
            index = i + j;
            if (j == 0) {
                // 连续字符串
                if (charMap.containsKey(count)) {
                    String cs = charMap.get(count) + p.charAt(index);
                    charMap.put(count, cs);
                } else {
                    count++;
                    charMap.put(count, String.valueOf(p.charAt(index)));
                }
            } else {
                int k = j % 2 == 0 ? j - 1 : j;
                for (; k > 0; k -= 2) {
                    if (starMap.containsKey(count)) {
                        char c = p.charAt(index - k);
                        String ss;
                        if (dot == c)
                            ss = String.valueOf(c);
                        else {
                            ss = starMap.get(count);
                            // 连续不相同星号匹配
                            char c1 = ss.charAt(ss.length() - 1);
                            if (c1 != c && c1 != dot)
                                ss = ss + c;
                        }
                        starMap.put(count, ss);
                    } else {
                        count++;
                        starMap.put(count, String.valueOf(p.charAt(index - k)));
                    }
                }
            }
            i = index + 1;
        }
        if (s.isEmpty())
            return charMap.isEmpty();
        else if (p.isEmpty())
            return false;

        List<Integer> indexes = new ArrayList<>();
        indexes.add(0);
        match(s, 0, 1, indexes);
        return ans;
    }


    private void match(String s, int startIndex, int step, List<Integer> indexes) {
        if (ans)
            return;
        int length = s.length();
        int count = starMap.size() + charMap.size();
        if (charMap.containsKey(step)) {
            String cs = charMap.get(step);
            if (indexes != null && !indexes.isEmpty()) {
                int nextStep = step + 1;
                for (int i : indexes) {
                    int index = startIndex + i;
                    if (charMatch(s, cs, index)) {
                        int nextStartIndex = index + cs.length();
                        match(s, nextStartIndex, nextStep, null);
                    }
                }
            }
        } else if (starMap.containsKey(step)) {
            String ss = starMap.get(step);
            char endWith;
            if (step == count)
                endWith = dot;
            else
                endWith = charMap.get(step + 1).charAt(0);
            indexes = starMatch(s, ss, startIndex, endWith);
            int nextStep = step + 1;
            match(s, startIndex, nextStep, indexes);
        } else {
            // 匹配完所有部分 判断是否匹配
            if (indexes != null && !indexes.isEmpty()) {
                for (int i : indexes) {
                    if (startIndex + i >= length) {
                        ans = true;
                        return;
                    }
                }
            } else
                ans = startIndex >= length;
        }
    }


    private boolean charMatch(String s, String cs, int index) {
        int length = cs.length();
        if (index + length > s.length())
            return false;
        for (int i = 0; i < length; i++) {
            char c = cs.charAt(i);
            if (dot == c)
                continue;
            if (s.charAt(index + i) != c)
                return false;

        }
        return true;
    }


    private List<Integer> starMatch(String s, String ss, int index, char endWith) {
        int length = ss.length();
        boolean isDot = ss.charAt(0) == dot;
        if (isDot) {
            List<Integer> indexes = new ArrayList<>();
            for (int x = index; x <= s.length(); x++) {
                char c = x == s.length() ? dot : s.charAt(x);
                // 下一个char匹配
                if (c == endWith || dot == endWith)
                    indexes.add(x - index);
            }
            return indexes;
        } else {
            int x = index;
            for (int i = 0; i < length; i++) {
                for (; x < s.length(); x++) {
                    char c = s.charAt(x);
                    if (c != ss.charAt(i))
                        break;
                }
                if (x == s.length())
                    break;
            }
            List<Integer> indexes = new ArrayList<>();
            for (int i = index; i <= x; i++) {
                char c = i == s.length() ? dot : s.charAt(i);
                if (c == endWith || dot == endWith)
                    indexes.add(i - index);
            }
            if (indexes.isEmpty())
                indexes.add(0);
            return indexes;
        }
    }

}

