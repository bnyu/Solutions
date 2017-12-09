/**
  * 53. Maximum Subarray
  * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
  * For example, given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous subarray [4,-1,2,1] has the largest sum = 6.
  */
object MaximumSubarray {
  def maxSubArray(nums: Array[Int]): Int = {
    val num = nums.dropWhile(_ > 0)
    if (num.isEmpty) 0 else {
      var ans = num.head
      var positive = true
      var sum = 0
      for (i <- num) {
        if (positive && i >= 0) {
          sum += i
        } else if (positive) {
          //直到遇到第一个负数 比较这部分
          positive = false
          ans = if (sum > ans) sum else ans
          sum += i
        } else if (i < 0) {
          //接着加 直到遇到下一个正数
          sum += i
        } else {
          //下一个正数开始 大于0接着加 否则重新开始
          sum = if (sum > 0) sum + i else i
          positive = true
        }
      }
      if (sum > ans) sum else ans
    }
  }
}

