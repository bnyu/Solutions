/**
 * 45. Jump Game II
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * For example: Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * Note: You can assume that you can always reach the last index.
 */
class Solution045 {
    fun jump(nums: IntArray): Int {
        return if (nums.size < 2) 0 else jump(nums, nums.size - 1, 0, 1)
    }

    private tailrec fun jump(num: IntArray, endIndex: Int, leftStep: Int, times: Int): Int {
        if (endIndex == 0)
            return times
        //距离终点距离
        var roadStep = leftStep
        //能直接到终点的最靠前位置
        var closetIndex = endIndex

        //距离最靠前位置closetIndex的距离
        var nextRoadStep = 0
        //能直接到最靠前位置
        var nextCloset = endIndex
        //下一步至少走距离
        var nextLeft = 0
        for (i in endIndex downTo 0) {
            val step = num[i]
            if (step >= roadStep) {
                closetIndex = i
                nextRoadStep = 0
            }
            if (step >= nextRoadStep) {
                nextCloset = i
                nextLeft = closetIndex - i
            }
            roadStep++
            nextRoadStep++
        }
        //下一步不用走 则次数不加1
        val nextTime = if (nextLeft > 0) times + 1 else times
        return jump(num, nextCloset, nextLeft, nextTime)
    }

}

