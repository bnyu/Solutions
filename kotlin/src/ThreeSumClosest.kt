/**
 * 16. 3Sum Closest
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 */
class ThreeSumClosest {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        val size = nums.size
        if (size < 3) return 0
        val numList = nums.toMutableList()
        quickSort(numList, 0, size - 1)
        val smallest = numList[0] + numList[1] + numList[2]
        val biggest = numList[size - 1] + numList[size - 2] + numList[size - 3]

        var sumPair = if (smallest >= target)
            return smallest
        else if (biggest <= target)
            return biggest
        else {
            val sDiff = Math.abs(smallest - target)
            val bDiff = Math.abs(biggest - target)
            if (sDiff <= bDiff) Pair(sDiff, smallest) else Pair(bDiff, biggest)
        }


        val numNum = mutableListOf<Pair<Int, Int>>()
        var preNum = numList[0]
        var n = 1
        for (i in 1 until size) {
            val num = numList[i]
            if (preNum != num) {
                numNum.add(Pair(preNum, n))
                preNum = num
                n = 0
            }
            ++n
        }
        numNum.add(Pair(numList[size - 1], n))

        val uniqueSize = numNum.size
        val partSumList = mutableListOf<Triple<Int, Int, Int>>()
        for (i in 0 until uniqueSize) {
            val a = numNum[i].first
            val aNum = numNum[i].second
            val index = if (aNum == 1) i + 1 else i
            for (j in index until uniqueSize) {
                val b = numNum[j].first
                val bNum = numNum[j].second
                val partSum = a + b
                partSumList.add(Triple(partSum, bNum, j))
            }
        }

        for (triple in partSumList) {
            val partNum = triple.first
            val needNum = target - partNum
            var first = if (triple.second <= 2) triple.third + 1 else triple.third
            var end = uniqueSize - 1
            if (first <= end && numList[end] >= needNum && numList[first] <= needNum) {
                while (end - first > 1) {
                    val mid = (end + first) / 2
                    val c = numList[mid]
                    if (needNum == c)
                        return target
                    if (needNum > c)
                        end = mid
                    else
                        first = mid
                }
                val fDiff = Math.abs(numList[first] - needNum)
                val eDiff = Math.abs(numList[end] - needNum)
                when {fDiff <= eDiff && fDiff < sumPair.first -> sumPair = Pair(fDiff, partNum + numList[first])
                    eDiff < sumPair.first -> sumPair = Pair(eDiff, partNum + numList[end])
                }
            }
        }
        return sumPair.second
    }

    private fun quickSort(nums: MutableList<Int>, first: Int, end: Int) {
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

