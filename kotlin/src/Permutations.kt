/**
 * p46. Permutations
 * Given a collection of distinct numbers, return all possible permutations.
 */
class Permutations {
    //循环调用S031就好了...
    fun permute(nums: IntArray): List<List<Int>> {
        val s = NextPermutation()
        val list = ArrayList<List<Int>>()
        var n = 1
        for (i in 1..nums.size) {
            n *= i
        }
        for (i in 1..n) {
            s.nextPermutation(nums)
            val permutation = nums.filter { true }
            list.add(permutation)
        }
        return list
    }
}

