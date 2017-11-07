//https://gist.github.com/bnyu/130b663f4f866181f8af39d5070aa41e
// Accepted

/**
 * 26. Remove Duplicates from Sorted Array
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example, Given input array nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 */
class Solution026 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int previous = nums[0];
        int lastIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == previous)
                continue;
            nums[lastIndex + 1] = nums[i];
            previous = nums[i];
            lastIndex++;
        }
        return lastIndex + 1;
    }
}

