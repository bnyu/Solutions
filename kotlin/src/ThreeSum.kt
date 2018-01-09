/**
 * 15. 3Sum
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Note: The solution set must not contain duplicate triplets.
 */
class ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val target = 0
        val sort = ThreeSumClosest()
        val size = nums.size
        if (size < 3) return emptyList()
        sort.quickSort(nums, 0, size - 1)
        val smallest = nums[0] + nums[1] + nums[2]
        val biggest = nums[size - 1] + nums[size - 2] + nums[size - 3]
        if (smallest > target || biggest < target) return emptyList()

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
        for (i in 0 until uniqueSize) {
            val a = numNum[i].first
            val aNum = numNum[i].second
            val canEqualA = aNum > 1
            val index = if (canEqualA) i else i + 1
            for (j in index until uniqueSize) {
                val b = numNum[j].first
                val bNum = numNum[j].second
                val canEqualB = bNum > 2 || bNum == 2 && i != j
                val c = target - a - b
                //即 k>j || k==j && canEqualB
                if (c > b || c == b && canEqualB) {
                    if (numNumMap.containsKey(c))
                        solutions.add(listOf(a, b, c))
                }
            }
        }
        return solutions
    }
}

