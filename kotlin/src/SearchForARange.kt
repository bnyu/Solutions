/**
 * 34. Search for a Range
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 */
class SearchForARange {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        var first = 0
        var last = nums.size - 1
        if (last < 0 || target < nums[first] || target > nums[last])
            return intArrayOf(-1, -1)
        //找到target的一个位置
        while (true) {
            if (last - first <= 1) {
                return if (nums[first] != target && nums[last] != target)
                    intArrayOf(-1, -1)
                else
                    break
            }
            val mid = (first + last) / 2
            if (nums[mid] > target)
                last = mid
            else if (nums[mid] < target)
                first = mid
            else
                break
        }
        var left = first
        var right = last
        left = findEdge(nums, first, last, target, left, false)
        last = right
        right = findEdge(nums, first, last, target, right, true)
        return intArrayOf(left, right)
    }

    //找到左右边界
    private fun findEdge(nums: IntArray, first: Int, last: Int, target: Int, leftOrRight: Int, findRight: Boolean): Int {
        var left = first
        var right = last
        if (nums[leftOrRight] != target) {
            while (true) {
                if (right - left <= 1) {
                    return if (nums[leftOrRight] == target)
                        if (findRight) right else left
                    else
                        if (findRight) left else right
                }
                val mid = (left + right) / 2
                if (nums[mid] == target) {
                    if (!findRight)
                        right = mid
                    else
                        left = mid
                } else {
                    if (!findRight)
                        left = mid
                    else
                        right = mid
                }
            }
        }
        return leftOrRight
    }
}
