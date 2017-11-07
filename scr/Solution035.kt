/**
 * 35. Search Insert Position
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 */
public class Solution035 {
    public int searchInsert(int[] nums, int target) {
        int first = 0;
        int last = nums.length - 1;
        if (last < 0 || target <= nums[first])
            return 0;
        else if (target > nums[last])
            return last + 1;
        while (true) {
            if (last - first <= 1) {
                if (target > nums[first])
                    return last;
                else return first;
            }
            int mid = (first + last) / 2;
            if (nums[mid] > target)
                last = mid;
            else if (nums[mid] < target)
                first = mid;
            else return mid;
        }
    }
}
