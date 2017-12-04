/**
 * 15. 3Sum
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Note: The solution set must not contain duplicate triplets.
 */
class ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        //数字个数
        val numNum = mutableMapOf<Int, Int>()
        val ans = mutableListOf<List<Int>>()
        var zeroTime = 0
        //记录是单个还是多个 除0需3个才满足
        for (n in nums) {
            if (numNum.containsKey(n))
                numNum.put(n, 2)
            else
                numNum.put(n, 1)
            if (n == 0)
                zeroTime++
        }
        if (nums.size < 3)
            return ans
        val matched = mutableMapOf<Int, MutableSet<Int>>()
        for (a in numNum.keys) {
            //每两个数之前的组合
            for (b in numNum.keys) {
                val bNum = numNum[b]
                //b作为a已经匹配过了
                if (bNum == 0)
                    continue
                //自身匹配 但只有单个
                if (a == b && bNum == 1)
                    continue
                val c = 0 - a - b
                //没有可以匹配成功的
                val cNum = numNum.getOrDefault(c, 0)
                if (cNum == 0)
                    continue
                //需要匹配的数为a/b 但只有单个
                if ((a == c || b == c) && cNum == 1)
                    continue
                //排除相同 用最大与最小区分
                val min = Math.min(a, Math.min(b, c))
                val max = Math.max(a, Math.max(b, c))
                if (min == max)
                    if (zeroTime < 3)
                        continue
                if (matched.containsKey(min)) {
                    val maxes = matched[min]!!
                    if (maxes.contains(max))
                        continue
                    else
                        maxes.add(max)
                } else {
                    val maxes = mutableSetOf<Int>()
                    maxes.add(max)
                    matched.put(min, maxes)
                }
                val list = listOf(a, b, c)
                ans.add(list)
            }
            numNum.put(a, 0)
        }
        return ans
    }
}

