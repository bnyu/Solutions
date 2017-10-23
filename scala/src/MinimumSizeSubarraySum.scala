/** 209. Minimum Size Subarray Sum
  * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
  * Example: Input: [2,3,1,2,4,3], s = 7; Output: 2; Explanation: the subarray [4,3] has the minimal length under the problem constraint.
  */
object MinimumSizeSubarraySum {
  def minSubArrayLen(s: Int, nums: Array[Int]): Int = {
    var min = nums.length
    var exist = false
    if (min > 0 && s > 0) {
      var start = 0 //include
      var end = 0 //exclude
      var sum = 0
      var loop = true
      while (loop) {
        //will loop once at least
        while (end < nums.length && sum < s) {
          sum += nums(end)
          end += 1
        }
        if (sum >= s) {
          exist = true
          //will loop once at least
          while (start < end && sum >= s) {
            sum -= nums(start)
            start += 1
          }
          val temp = end - start + 1
          if (temp < min) {
            min = temp
            if (min == 1)
              loop = false
          }
        } else loop = false
      }
    }
    if (exist) min else 0
  }
}

