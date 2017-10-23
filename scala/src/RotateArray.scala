/** 189. Rotate Array
  * Given an array, rotate the array to the right by k steps, where k is non-negative.
  * Example 1: Input: [1,2,3,4,5,6,7] and k = 3; Output: [5,6,7,1,2,3,4]
  * Explanation: rotate 1 steps to the right: [7,1,2,3,4,5,6]  rotate 2 steps to the right: [6,7,1,2,3,4,5]
  * Note: Could you do it in-place with O(1) extra space?
  */
object RotateArray {
  def rotate(nums: Array[Int], k: Int): Unit = {
    //O(1) memory
    if (nums.length > 0 && k > 0) {
      val x = k % nums.length
      var n = 0
      while (n < x) {
        val index = nums.length - x + n
        val temp = nums(index)
        for (i <- index until n by -1)
          nums(i) = nums(i - 1)
        nums(n) = temp
        n += 1
      }
    }
  }
}

