package p27;
//https://gist.github.com/bnyu/a860db09baa643caeb584402bd9d6fdd
// Accepted

/**
 * 27. Remove Element
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0)
            return 0;
        int index = 0;
        for (int x : nums) {
            if (x != val) {
                nums[index] = x;
                index++;
            }
        }
        return index;
    }
}

