//https://gist.github.com/bnyu/637ca75063000803d7728dd150ff0119
// Accepted

/**
 * 1. Two Sum
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
class Solution001 {
    public int[] twoSum(int[] nums, int target) {
        int[] sum = new int[2];
        breakFor:
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    sum[0] = i;
                    sum[1] = j;
                    break breakFor;
                }
            }
        }
        return sum;
    }
}

