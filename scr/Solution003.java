//https://gist.github.com/bnyu/78dfc31c9b9e58a64ffa1a2dc2cf703d
// Accepted

import java.util.*;

/**
 * 3. Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters.
 */
class Solution003 {
    public int lengthOfLongestSubstring(String s) {
        int sLen;
        if (s == null || s.isEmpty())
            return 0;
        else if ((sLen = s.length()) == 1)
            return 1;
        int maxLen = 1;
        Map<Character, List<Integer>> dupCharIndex = new HashMap<>();
        Set<Character> characters = new HashSet<>();
        Set<Character> dupCharSet = new HashSet<>();
        Map<Integer, Character> dupCharMap = new HashMap<>();
        //找出每个重复字符
        for (int i = 0; i < sLen; i++) {
            char c = s.charAt(i);
            if (characters.contains(c)) {
                if (!dupCharSet.contains(c))
                    dupCharSet.add(c);
            } else
                characters.add(c);
        }
        if (dupCharSet.isEmpty())
            return sLen;
        //分别记录重复字符位置
        for (int i = 0; i < sLen; i++) {
            char c = s.charAt(i);
            if (dupCharSet.contains(c)) {
                //key:位置 valve:字符
                dupCharMap.put(i, c);
                if (dupCharIndex.containsKey(c))
                    //key:字符 valve:所有位置
                    dupCharIndex.get(c).add(i);
                else {
                    List<Integer> list = new ArrayList<>();
                    //首
                    list.add(-1);
                    list.add(i);
                    dupCharIndex.put(c, list);
                }
            }
        }
        Map<Character, Integer> dupMap = new HashMap<>();
        //循环所有重复字符
        for (List<Integer> indexes : dupCharIndex.values()) {
            //尾
            indexes.add(sLen - 1);
            int indexLength = indexes.size();
            //判断3个重复字符之间是否还有其他重复字符
            for (int i = 0; i < indexLength - 1; ) {
                int leftIndex = indexes.get(i);
                int midIndex = indexes.get(i + 1);
                int rightIndex = i + 2 == indexLength ? midIndex : indexes.get(i + 2);
                //重复位置
                int dupIndex = leftIndex;
                if (rightIndex - leftIndex > maxLen) {
                    boolean hasOtherDup = false;
                    for (int index = leftIndex + 1; index <= rightIndex; index++) {
                        if (dupCharMap.containsKey(index)) {
                            char dupChar = dupCharMap.get(index);
                            if (dupMap.containsKey(dupChar)) {
                                rightIndex = index;
                                hasOtherDup = true;
                                dupIndex = dupMap.get(dupChar);
                                break;
                            } else
                                dupMap.put(dupChar, index);
                        }
                    }
                    dupMap.clear();
                    int needRemove = hasOtherDup ? 1 : 0;
                    int len = rightIndex - leftIndex - needRemove;
                    if (len > maxLen) {
                        maxLen = len;
                        //最长
                        if (maxLen >= characters.size())
                            return maxLen;
                    }
                }
                //重复在下一个右侧 跳过下一个
                i = dupIndex > midIndex ? i + 2 : i + 1;
            }
        }
        return maxLen;
    }
}

