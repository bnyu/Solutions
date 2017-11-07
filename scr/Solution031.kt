/**
 * 31. Next Permutation
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 */
class Solution031 {
    fun nextPermutation(nums: IntArray) {
        val lastIndex = nums.size - 1
        var index = lastIndex

        // 尾部是最大序的前一个位置
        var sortedIndex = lastIndex
        while (sortedIndex > 0) {
            if (nums[sortedIndex - 1] < nums[sortedIndex])
                break
            sortedIndex--
        }
        sortedIndex--

        BreakFor@ while (index >= 0) {
            if (sortedIndex < 0) {
                index = -1
                break
            }
            if (index == sortedIndex) {
                sortedIndex--
                index = lastIndex
            }
            var j = 1
            while (index - j >= 0) {
                if (index - j < sortedIndex)
                    break
                if (nums[index - j] < nums[index]) {
                    val temp = nums[index - j]
                    nums[index - j] = nums[index]
                    nums[index] = temp
                    index = index - j + 1
                    break@BreakFor
                }
                j++
            }
            index--
        }

        //已是最大序 变为最小序
        if (index == -1)
            index = 0
        var i = index
        var j = lastIndex
        while (i < j) {
            val temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp
            i++
            j--
        }
    }
}

