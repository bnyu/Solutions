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
        val partSumMap = mutableMapOf<Int, MutableList<Triple<Int, Int, Int>>>()
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
                val tripleList = partSumMap.getOrPut(partSum, { mutableListOf() })
                tripleList.add(Triple(i, bNum, j))
            }
        }

        val solutions = mutableListOf<List<Int>>()
        val invalidPart = emptyList<Triple<Int, Int, Int>>()
        for (part in partSumMap) {
            val partSum = part.key
            val thePart = part.value
            val needNum = target - partSum
            val otherPart = partSumMap.getOrDefault(needNum, invalidPart)

            for (ab in thePart) {
                for (cd in otherPart) {
                    val matched = when {
                        ab.third < cd.first -> true
                        ab.third > cd.first -> false
                        ab.second >= 4 -> true
                        ab.second == 3 && (ab.first != ab.third || cd.first != cd.third) -> true
                        ab.second == 2 && ab.first != ab.third && cd.first != cd.third -> true
                        else -> false
                    }
                    if (matched) {
                        val four = listOf(numNum[ab.first].first, numNum[ab.third].first, numNum[cd.first].first, numNum[cd.third].first)
                        solutions.add(four)
                    }
                }
            }
        }
        return solutions
    }
}

