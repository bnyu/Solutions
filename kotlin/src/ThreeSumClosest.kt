/**
 * 16. 3Sum Closest
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 */
class ThreeSumClosest {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        val size = nums.size
        if (size < 3) return 0
        quickSort(nums, 0, size - 1)
        val smallest = nums[0] + nums[1] + nums[2]
        val biggest = nums[size - 1] + nums[size - 2] + nums[size - 3]

        if (smallest >= target)
            return smallest
        else if (biggest <= target)
            return biggest

        val partSumMap = mutableMapOf<Int, Int>()
        val partSumList = mutableListOf<Int>()
        var preFirst: Int? = null
        for (i in 0 until nums.size - 2) {
            val first = nums[i]
            if (first == preFirst)
                continue
            preFirst = first
            var preSecond: Int? = null
            for (j in i + 1 until nums.size - 1) {
                val second = nums[j]
                if (second == preSecond)
                    continue
                preSecond = second
                val partSum = first + second
                // 相同partSum 覆盖之前的 即取j更小的情况
                partSumMap.put(partSum, j)
                partSumList.add(partSum)
            }
        }

        val partSums = partSumList.toIntArray()
        quickSort(partSums, 0, partSums.size - 1)
        var i = size - 1
        var k = partSums.size - 1

        //todo temp
        return 0

    }

    private fun quickSort(nums: IntArray, first: Int, end: Int) {
        var i = first
        var k = end
        val mid = nums[k]
        while (i < k) {
            while (nums[i] <= mid && i < k)
                ++i
            if (i < k)
                nums[k] = nums[i]
            while (nums[k] >= mid && i < k)
                --k
            if (i < k)
                nums[i] = nums[k]
            nums[k] = mid
        }
        if (k > first)
            quickSort(nums, first, k - 1)
        if (k < end)
            quickSort(nums, k + 1, end)
    }
}

