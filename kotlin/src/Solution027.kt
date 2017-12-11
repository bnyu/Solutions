/**
 * 27. Remove Element
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
class Solution027 {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        if (nums.isEmpty())
            return 0
        var index = 0
        for (x in nums) {
            if (x != `val`) {
                nums[index] = x
                index++
            }
        }
        return index
    }
}

