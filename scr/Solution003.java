//https://gist.github.com/bnyu/78dfc31c9b9e58a64ffa1a2dc2cf703d
// Time Limit Exceeded

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
        Map<Character, List<Integer>> duplicateIndex = new HashMap<>();
        Set<Character> characters = new HashSet<>();
        Set<Character> dupCharSet = new HashSet<>();
        Map<Integer, Character> dupCharMap = new HashMap<>();
        //找出每个重复字符
        for (int i = 0; i < sLen; i++) {
            char c = s.charAt(i);
            if (characters.contains(c))
                dupCharSet.add(c);
            else
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
                if (duplicateIndex.containsKey(c))
                    //key:字符 valve:所有位置
                    duplicateIndex.get(c).add(i);
                else {
                    List<Integer> list = new ArrayList<>();
                    //首
                    list.add(-1);
                    list.add(i);
                    duplicateIndex.put(c, list);
                }
            }
        }
        dupCharSet.clear();
        //循环所有重复字符
        for (List<Integer> indexes : duplicateIndex.values()) {
            //尾
            indexes.add(sLen - 1);
            int indexLength = indexes.size();
            //判断3个重复字符之间是否还有其他重复字符
            for (int i = 0; i < indexLength - 1; i++) {
                int leftIndex = indexes.get(i);
                int rightIndex = i + 2 == indexLength ? indexes.get(i + 1) : indexes.get(i + 2);
                if (rightIndex - leftIndex > maxLen) {
                    boolean hasOtherDup = false;
                    for (int index = leftIndex + 1; index <= rightIndex; index++) {
                        if (dupCharMap.containsKey(index)) {
                            char dupChar = dupCharMap.get(index);
                            if (dupCharSet.contains(dupChar)) {
                                rightIndex = index;
                                hasOtherDup = true;
                                break;
                            } else
                                dupCharSet.add(dupChar);

                        }
                    }
                    dupCharSet.clear();
                    int needRemove = hasOtherDup ? 1 : 0;
                    int len;
                    if ((len = rightIndex - leftIndex - needRemove) > maxLen)
                        maxLen = len;
                }
            }
        }
        return maxLen;
    }
}

