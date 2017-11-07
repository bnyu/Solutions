//https://gist.github.com/bnyu/30d032f7fa26a820b22cdf99978ebcd5
// Accepted

import java.util.*;

/**
 * 15. 3Sum
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Note: The solution set must not contain duplicate triplets.
 */
class Solution015 {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> numNum = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        int zeroTime = 0;
        for (int n : nums) {
            if (numNum.containsKey(n))
                numNum.put(n, 2);
            else numNum.put(n, 1);
            if (n == 0)
                zeroTime++;
        }
        if (nums.length < 3)
            return ans;
        Map<Integer, Set<Integer>> matched = new HashMap<>();
        for (int a : numNum.keySet()) {
            int aNum = numNum.get(a);
            for (int b : numNum.keySet()) {
                int bNum = numNum.get(b);
                if (bNum == 0)
                    continue;
                if (a == b && bNum == 1)
                    continue;
                int c = 0 - a - b;
                int cNum = numNum.getOrDefault(c, 0);
                if (cNum == 0)
                    continue;
                if ((a == c || b == c) && cNum == 1)
                    continue;
                int min = Math.min(a, Math.min(b, c));
                int max = Math.max(a, Math.max(b, c));
                if (min == max)
                    if (zeroTime < 3)
                        continue;
                if (matched.containsKey(min)) {
                    Set<Integer> maxes = matched.get(min);
                    if (maxes.contains(max))
                        continue;
                    else maxes.add(max);
                } else {
                    Set<Integer> maxes = new HashSet<>();
                    maxes.add(max);
                    matched.put(min, maxes);
                }
                List<Integer> list = new ArrayList<>();
                list.add(c);
                list.add(b);
                list.add(a);
                ans.add(list);
            }
            numNum.put(a, 0);
        }
        return ans;
    }
}

