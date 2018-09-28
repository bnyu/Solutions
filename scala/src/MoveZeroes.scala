/** 283. Move Zeroes
  * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
  * Example: Input: [0,1,0,3,12] Output: [1,3,12,0,0]
  * Note: You must do this in-place without making a copy of the array. Minimize the total number of operations.
  */
object MoveZeroes {
  def moveZeroes(nums: Array[Int]): Unit = {
    val len = nums.length
    var index = 0
    var zeroNum = 0
    for (i <- nums.indices) {
      val n = nums(i)
      if (n != 0) {
        nums(index) = n
        index += 1
      } else {
        zeroNum += 1
      }
    }
    for (i <- 1 to zeroNum) {
      nums(len - i) = 0
    }
  }
}
