/**
 * 18. 4Sum
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * Note: The solution set must not contain duplicate quadruplets.
 */
class FourSum {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val size = nums.size
        if (size < 4) return emptyList()
        val sort = ThreeSumClosest()
        sort.quickSort(nums, 0, size - 1)

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

        val uniqueSize = numNum.size
        val partSumMap = mutableMapOf<Int, Triple<Int, Int, Int>>()
        for (i in 0 until uniqueSize) {
            val a = numNum[i]
            val aN = a.first
            val aNum = a.second
            val index = if (aNum == 1) i + 1 else i
            for (j in index until uniqueSize) {
                val b = numNum[j]
                val bN = b.first
                val partSum = aN + bN
                val bNum = b.second
                partSumMap.put(partSum, Triple(i, bNum, j))
            }
        }

        val solutions = mutableListOf<List<Int>>()
        val invalidPart = Triple(-1, -1, -1)
        for (part in partSumMap) {
            val partSum = part.key
            val thePart = part.value
            val needNum = target - partSum
            val otherPart = partSumMap.getOrDefault(needNum, invalidPart)
            val matched = when {
                thePart.third < otherPart.first -> true
                thePart.third > otherPart.first -> false
                thePart.second >= 4 -> true
                thePart.second == 3 && (thePart.first != thePart.third || otherPart.first != otherPart.third) -> true
                thePart.second == 2 && thePart.first != thePart.third && otherPart.first != otherPart.third -> true
                else -> false
            }
            if (matched) {
                val four = listOf(numNum[thePart.first].first, numNum[thePart.third].first, numNum[otherPart.first].first, numNum[otherPart.third].first)
                solutions.add(four)
            }
        }
        return solutions
    }
}

