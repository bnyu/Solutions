/**
 * 33. Search in Rotated Sorted Array
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 */
class Solution033 {
    fun search(nums: IntArray, target: Int): Int {
        var first = 0
        var last = nums.size - 1
        if (last < 0)
            return -1
        //找到转折位置
        var mid: Int
        while (true) {
            mid = (first + last) / 2
            if (last - first <= 1)
                break
            if (nums[mid] >= nums[first])
                first = mid
            else
                last = mid
        }
        mid = if (nums[first] >= nums[last]) first else last
        first = 0
        last = nums.size - 1
        //大致判断区间
        var possible = true
        if (target >= nums[first] && target <= nums[mid])
            last = mid
        else if (target <= nums[last] && mid < last && target >= nums[mid + 1])
            first = mid + 1
        else possible = false
        //二分查找
        while (possible) {
            mid = (first + last) / 2
            if (last - first <= 1)
                break
            if (target > nums[mid])
                first = mid
            else last = mid
        }
        return when (target) {
            nums[first] -> first
            nums[last] -> last
            else -> -1
        }
    }

}

