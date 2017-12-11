/**
 * 1. Two Sum
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
class Solution001 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val sum = IntArray(2)
        val map = HashMap<Int, Int>()
        val map1 = HashMap<Int, Int>()
        for (i in 0 until nums.size) {
            if (!map.containsKey(nums[i]))
                map.put(nums[i], i)
            //重复的值 不覆盖第一个indices
            else map1.put(nums[i], i)
        }
        for (x in map.keys) {
            val matched = target - x
            //若需匹配的值等于自身 从map1里寻找
            val map2 = if (matched != x) map else map1
            if (map2.containsKey(matched)) {
                sum[0] = map.getOrDefault(x, -1)
                sum[1] = map2.getOrDefault(matched, -1)
                break
            }
        }
        return sum
    }
}

