/**
 * 15. 3Sum
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Note: The solution set must not contain duplicate triplets.
 */
class ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val sort = ThreeSumClosest()
        val size = nums.size
        if (size < 3) return emptyList()
        sort.quickSort(nums, 0, size - 1)
        val smallest = nums[0] + nums[1] + nums[2]
        val biggest = nums[size - 1] + nums[size - 2] + nums[size - 3]
        if (smallest > 0 || biggest < 0) return emptyList()

        val numNum = mutableListOf<Pair<Int, Int>>()
        var preNum = nums[0]
        var n = 1
        for (i in 1 until size) {
            val num = nums[i]
            if (preNum != num) {
                numNum.add(Pair(preNum, n))
                preNum = num
                n = 0
            }
            ++n
        }
        numNum.add(Pair(nums[size - 1], n))
        val numNumMap = numNum.toMap()

        val solutions = mutableListOf<List<Int>>()
        val uniqueSize = numNum.size
        for (i in 0 until uniqueSize - 2) {
            val a = numNum[i].first
            for (j in i + 1 until uniqueSize - 1) {
                val b = numNum[j].first
                val bNum = numNum[j].second
                val c = 0 - a - b
                if (c > b && numNumMap.contains(c) || c == b && bNum >= 2)
                    solutions.add(listOf(a, b, c))
            }
        }
        if (numNumMap.getOrDefault(0, 0) >= 3)
            solutions.add(listOf(0, 0, 0))
        return solutions
    }
}

