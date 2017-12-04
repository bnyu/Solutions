/**
 * 39. Combination Sum
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [2, 3, 6, 7] and target 7,
 * A solution set is:
 * [[7],[2, 2, 3]]
 */
class CombinationSum {
    private val ans = ArrayList<List<Int>>()

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        sort(candidates, 0, candidates.size - 1)
        combine(ArrayList(), candidates, 0, target)
        return ans
    }

    private fun combine(list: List<Int>, candidates: IntArray, startIndex: Int, target: Int) {
        //从当前最大的数字开始依次尝试
        for (i in startIndex until candidates.size) {
            val number = candidates[i]
            val nextTarget = target - candidates[i]
            if (nextTarget >= 0) {
                val nextList = ArrayList<Int>()
                nextList.addAll(list)
                nextList.add(number)
                if (target == 0) {
                    ans.add(list)
                    return
                } else
                    combine(nextList, candidates, i, nextTarget)
            }
        }
    }

    //降序
    private fun sort(nums: IntArray, start: Int, end: Int) {
        if (end <= start)
            return
        val meddle = nums[end]
        var left = start
        var right = end
        while (left < right) {
            while (left < right && nums[left] >= meddle)
                left++
            if (left < right)
                nums[right] = nums[left]

            while (left < right && nums[right] <= meddle)
                right--
            if (left < right)
                nums[left] = nums[right]

            nums[right] = meddle
        }
        if (start < left)
            sort(nums, start, left - 1)
        if (end > right)
            sort(nums, right + 1, end)
    }

}

