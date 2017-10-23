/**
 * 45. Jump Game II
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * For example: Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * Note: You can assume that you can always reach the last index.
 */
class JumpGame2 {
    fun jump(nums: IntArray): Int {
        return if (nums.size < 2) 0 else jump(nums, nums.size - 1, 0)
    }

    private tailrec fun jump(num: IntArray, endIndex: Int, times: Int): Int {
        if (endIndex == 0)
            return times
        var closetIndex = endIndex
        var roadStep = 0
        for (i in endIndex downTo 0) {
            val step = num[i]
            if (step >= roadStep) {
                closetIndex = i
            }
            roadStep++
        }
        return jump(num, closetIndex, times + 1)
    }

}

