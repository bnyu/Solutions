/**
 * 35. Search Insert Position
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 */
class Solution035 {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var first = 0
        var last = nums.size - 1
        if (last < 0 || target <= nums[first])
            return 0
        else if (target > nums[last])
            return last + 1
        //二分法查找
        while (true) {
            if (last - first <= 1) {
                return if (target > nums[first])
                    last
                else
                    first
            }
            val mid = (first + last) / 2
            if (nums[mid] > target)
                last = mid
            else if (nums[mid] < target)
                first = mid
            else
                return mid
        }
    }
}
