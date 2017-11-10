/**
 * 41. First Missing Positive
 * Given an unsorted integer array, find the first missing positive integer.
 * For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 * Your algorithm should run in O(n) time and uses constant space.
 */
class Solution041 {
    fun firstMissingPositive(nums: IntArray): Int {
        val positiveNum = mutableSetOf<Int>()
        positiveNum.addAll(nums.filter { x -> x > 0 })
        for (i in 1..positiveNum.size)
            if (!positiveNum.contains(i))
                return i
        return positiveNum.size + 1
    }
}

