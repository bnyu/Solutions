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
        val partSumList = mutableListOf<Triple<Int, Boolean, Int>>()
        for (i in 0 until uniqueSize) {
            val a = numNum[i].first
            val aNum = numNum[i].second
            val index = if (aNum == 1) i + 1 else i
            for (j in index until uniqueSize) {
                val b = numNum[j].first
                val bNum = numNum[j].second
                val partSum = a + b
                val canEqualB = bNum > 2 || bNum == 2 && i != j
                partSumList.add(Triple(partSum, canEqualB, j))
            }
        }

        for (triple in partSumList) {
            val partNum = triple.first
            val needNum = target - partNum
            var first = if (triple.second) triple.third else triple.third + 1
            var end = uniqueSize - 1
            if (first > end)
                continue
            if (numNum[end].first > needNum && numNum[first].first < needNum) {
                while (end - first > 1) {
                    val mid = (end + first) / 2
                    val c = numNum[mid].first
                    if (needNum == c)
                        return target
                    if (needNum > c)
                        first = mid
                    else
                        end = mid
                }
            }
            val fDiff = Math.abs(numNum[first].first - needNum)
            val eDiff = Math.abs(numNum[end].first - needNum)
            when {
                fDiff <= eDiff && fDiff < sumPair.first -> sumPair = Pair(fDiff, partNum + numNum[first].first)
                eDiff < sumPair.first -> sumPair = Pair(eDiff, partNum + numNum[end].first)
            }
            if (sumPair.first == 0)
                return sumPair.second
        }
        return sumPair.second
    }

    fun quickSort(nums: IntArray, first: Int, end: Int) {
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

