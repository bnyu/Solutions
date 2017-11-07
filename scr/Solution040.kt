import java.util.ArrayList;
import java.util.List;

/**
 * 40. Combination Sum 2
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 * A solution set is:[[1, 7],[1, 2, 5],[2, 6],[1, 1, 6]]
 */
public class Solution040 {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        sort(candidates, 0, candidates.length - 1);
        combine(null, candidates, 0, target);
        return ans;
    }

    private void combine(List<Integer> list, int[] candidates, int startIndex, int target) {
        int lastNumber = -1;
        for (int i = startIndex; i < candidates.length; i++) {
            int number = candidates[i];
            if (number == lastNumber)
                continue;
            lastNumber = number;
            int nextTarget = target - candidates[i];
            if (nextTarget >= 0) {
                List<Integer> nextList = new ArrayList<>();
                if (list != null)
                    nextList.addAll(list);
                nextList.add(number);
                if (nextTarget == 0)
                    ans.add(nextList);
                else
                    combine(nextList, candidates, i + 1, nextTarget);
            }
        }
    }

    //升序
    private void sort(int[] nums, int start, int end) {
        if (end <= start)
            return;
        int meddle = nums[end];
        int left = start;
        int right = end;
        while (left < right) {
            while (left < right && nums[left] <= meddle)
                left++;
            if (left < right)
                nums[right] = nums[left];

            while (left < right && nums[right] >= meddle)
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
