import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 39. Combination Sum
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [2, 3, 6, 7] and target 7,
 * A solution set is:
 * [[7],[2, 2, 3]]
 */
public class Solution039 {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        sort(candidates, 0, candidates.length - 1);
        combine(null, candidates, 0, target);
        return ans;
    }

    private void combine(List<Integer> list, int[] candidates, int startIndex, int target) {
        if (target == 0) {
            ans.add(list);
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            int number = candidates[i];
            int nextTarget = target - candidates[i];
            if (nextTarget >= 0) {
                List<Integer> nextList = new ArrayList<>();
                if (list != null)
                    nextList.addAll(list);
                nextList.add(number);
                combine(nextList, candidates, i, nextTarget);
            }
        }
    }

    private void sort(int[] nums, int start, int end) {
        if (end <= start)
            return;
        int meddle = nums[end];
        int left = start;
        int right = end;
        while (left < right) {
            while (left < right && nums[left] >= meddle)
                left++;
            if (left < right)
                nums[right] = nums[left];

            while (left < right && nums[right] <= meddle)
                right--;
            if (left < right)
                nums[left] = nums[right];

            nums[right] = meddle;
        }
        if (start < left)
            sort(nums, start, left - 1);
        if (end > right)
            sort(nums, right + 1, end);
    }

}

