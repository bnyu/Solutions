/** 238. Product of Array Except Self
  * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
  * Example: Input:  [1,2,3,4]  Output: [24,12,8,6]
  * Note: Please solve it without division and in O(n).
  * Follow up: Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
  */
object ProductOfArrayExceptSelf {
  def productExceptSelf(nums: Array[Int]): Array[Int] = {
    val ans = new Array[Int](nums.length)
    var p = 1
    for (i <- nums.indices) {
      ans(i) = p
      p *= nums(i)
    }
    p = 1
    for (i <- nums.indices.reverse) {
      ans(i) *= p
      p *= nums(i)
    }
    ans
  }
}
