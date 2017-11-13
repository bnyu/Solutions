/**
 * p46. Permutations
 * Given a collection of distinct numbers, return all possible permutations.
 */
class Solution046 {
    //循环调用S031排除重复就好了...
    fun permute(nums: IntArray): List<List<Int>> {
        val s = Solution031()
        val list = ArrayList<List<Int>>()
        var n = 1
        for (i in 1..nums.size) {
            n *= i
        }
        val origin = nums.filter { true }
        for (i in 1..n) {
            s.nextPermutation(nums)
            val permutation = nums.filter { true }
            list.add(permutation)
            if (permutation == origin)
                break
        }
        return list
    }
}

