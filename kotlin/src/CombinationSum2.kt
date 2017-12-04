/**
 * 40. Combination Sum 2
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 * A solution set is:[[1, 7],[1, 2, 5],[2, 6],[1, 1, 6]]
 */
class CombinationSum2 {
    private val ans = ArrayList<List<Int>>()

    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        sort(candidates, 0, candidates.size - 1)
        combine(ArrayList(), candidates, 0, target)
        return ans
    }

    //组合一个数字
    private fun combine(list: List<Int>, candidates: IntArray, startIndex: Int, target: Int) {
        var lastNumber = -1
        //从最小开始 依次尝试组合
        for (i in startIndex until candidates.size) {
            val number = candidates[i]
            //循环中排除相同的数字
            if (number == lastNumber)
                continue
            lastNumber = number
            val nextTarget = target - candidates[i]
            if (nextTarget >= 0) {
                val nextList = ArrayList<Int>()
                nextList.addAll(list)
                nextList.add(number)
                if (nextTarget == 0)
                    ans.add(nextList)
                //每个数字仅能用一次 从下一个数字开始组合
                else
                    combine(nextList, candidates, i + 1, nextTarget)
            }
        }
    }

    //升序
    private fun sort(nums: IntArray, start: Int, end: Int) {
        if (end <= start)
            return
        val meddle = nums[end]
        var left = start
        var right = end
        while (left < right) {
            while (left < right && nums[left] <= meddle)
                left++
            if (left < right)
                nums[right] = nums[left]

            while (left < right && nums[right] >= meddle)
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
