/**
 * 47. Permutations II
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 */
class Permutations2 {
    //同s046, 再过滤多余重复
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        val s = NextPermutation()
        val list = ArrayList<List<Int>>()
        var n = 1
        for (i in 1..nums.size) {
            n *= i
        }
        val origin = nums.filter { true }
        list.add(origin)
        for (i in 1..n) {
            s.nextPermutation(nums)
            val permutation = nums.filter { true }
            if (permutation == origin)
                break
            list.add(permutation)
        }
        return list
    }
}

