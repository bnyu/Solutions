/**
 * 34. Search for a Range
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 */
public class Solution034 {
    public int[] searchRange(int[] nums, int target) {
        int first = 0;
        int last = nums.length - 1;
        if (last < 0 || target < nums[first] || target > nums[last])
            return new int[]{-1, -1};
        while (true) {
            if (last - first <= 1) {
                if (nums[first] != target && nums[last] != target)
                    return new int[]{-1, -1};
                else break;
            }
            int mid = (first + last) / 2;
            if (nums[mid] > target)
                last = mid;
            else if (nums[mid] < target)
                first = mid;
            else break;
        }
        int left = first;
        int right = last;
        if (nums[left] != target) {
            while (true) {
                if (last - first <= 1) {
                    if (nums[first] == target)
                        left = first;
                    else
                        left = last;
                    break;
                }
                int mid = (first + last) / 2;
                if (nums[mid] == target)
                    last = mid;
                else
                    first = mid;
            }
        }
        last = right;
        if (nums[right] != target) {
            while (true) {
                if (last - first <= 1) {
                    if (nums[last] == target)
                        right = last;
                    else
                        right = first;
                    break;
                }
                int mid = (first + last) / 2;
                if (nums[mid] == target)
                    first = mid;
                else
                    last = mid;
            }
        }
        return new int[]{left, right};
    }
}
