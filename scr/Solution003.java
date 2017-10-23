//https://gist.github.com/bnyu/78dfc31c9b9e58a64ffa1a2dc2cf703d
// Time Limit Exceeded

import java.util.HashMap;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters.
 */
class Solution003 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty())
            return 0;
        else if (s.length() == 1)
            return 1;
        int mostLen = 1;
        char chs[] = s.toCharArray();
        Map<Character, Integer> mapL = new HashMap<>();
        Map<Character, Integer> mapR = new HashMap<>();
        mapL.put(chs[0], 0);
        boolean L = true;
        int duIndex;

        for (int i = 1; i < chs.length; i++) {
            char ch = chs[i];
            if (L) {
                if (!mapL.containsKey(ch))
                    mapL.put(ch, i);
                else {
                    mostLen = Math.max(mostLen, mapL.size());
                    duIndex = mapL.get(ch);
                    mapR.clear();
                    for (int j = duIndex + 1; j <= i; j++)
                        mapR.put(chs[j], j);
                    L = false;
                }
            } else {
                if (!mapR.containsKey(ch))
                    mapR.put(ch, i);
                else {
                    mostLen = Math.max(mostLen, mapR.size());
                    duIndex = mapR.get(ch);
                    mapL.clear();
                    for (int k = duIndex + 1; k <= i; k++)
                        mapL.put(chs[k], k);
                    L = true;
                }
            }
            mostLen = Math.max(mostLen, Math.max(mapL.size(), mapR.size()));
        }
        return mostLen;
    }
}

