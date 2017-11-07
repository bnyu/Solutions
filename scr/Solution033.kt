/**
 * 33. Search in Rotated Sorted Array
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 */
class Solution033 {
    public int search(int[] nums, int target) {
        int first = 0;
        int last = nums.length - 1;
        if (last < 0)
            return -1;
        int mid;
        while (true) {
            mid = (first + last) / 2;
            if (last - first <= 1)
                break;
            if (nums[mid] >= nums[first])
                first = mid;
            else last = mid;
        }
        if (nums[first] >= nums[last])
            mid = first;
        else mid = last;

        first = 0;
        last = nums.length - 1;
        boolean possible = true;
        if (target >= nums[first] && target <= nums[mid])
            last = mid;
        else if (target <= nums[last] && mid < last && target >= nums[mid + 1])
            first = mid + 1;
        else possible = false;
        while (possible) {
            mid = (first + last) / 2;
            if (last - first <= 1)
                break;
            if (target > nums[mid])
                first = mid;
            else last = mid;
        }
        if (target == nums[first])
            return first;
        else if (target == nums[last])
            return last;
        else return -1;
    }

}

