//https://gist.github.com/bnyu/30d032f7fa26a820b22cdf99978ebcd5
// Time Limit Exceeded

import java.util.*;

/**
 * 15. 3Sum
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Note: The solution set must not contain duplicate triplets.
 */
class Solution015 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int length = nums.length;
        if (length < 3)
            return ans;
        Set<String> uniques = new HashSet<>();
        Set<Integer> aSet = new HashSet<>();
        Set<Integer> bSet = new HashSet<>();
        Map<Integer, Integer> all = new HashMap<>();
        for (int k = length - 1; k > 1; k--) {
            int n = nums[k];
            if (!all.containsKey(n))
                all.put(n, k);
        }

        for (int i = 0; i < length - 2; i++) {
            int a = nums[i];
            if (aSet.contains(a))
                continue;
            aSet.add(a);
            bSet.clear();
            int temp = ~a + 1;
            for (int j = i + 1; j < length - 1; j++) {
                int b = nums[j];
                if (bSet.contains(b))
                    continue;
                int x = temp - b;
                bSet.add(b);
                bSet.add(x);
                int max;
                int min;
                boolean ab = a > b;
                boolean ax = a > x;
                boolean bx = b > x;
                if (ab) {
                    max = ax ? a : x;
                    min = bx ? x : b;
                } else {
                    max = bx ? b : x;
                    min = ax ? x : a;
                }
                String s = min + " " + max;
                if (uniques.contains(s))
                    continue;
                uniques.add(s);
                if (all.containsKey(x)) {
                    if (all.get(x) > j) {
                        List<Integer> list = new ArrayList<>(3);
                        list.add(a);
                        list.add(b);
                        list.add(x);
                        ans.add(list);
                    }
                }
            }
        }
        return ans;
    }
}

