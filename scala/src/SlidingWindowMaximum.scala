import scala.collection.mutable

/** 239. Sliding Window Maximum
  * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
  * Example: Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3   Output: [3,3,5,5,6,7]
  * Explanation:
  * Window position                Max
  * ---------------               -----
  * [1  3  -1] -3  5  3  6  7       3
  * 1 [3  -1  -3] 5  3  6  7       3
  * 1  3 [-1  -3  5] 3  6  7       5
  * 1  3  -1 [-3  5  3] 6  7       5
  * 1  3  -1  -3 [5  3  6] 7       6
  * 1  3  -1  -3  5 [3  6  7]      7
  * Note: You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
  * Follow up: Could you solve it in linear time?
  */
object SlidingWindowMaximum {
  def maxSlidingWindow(nums: Array[Int], k: Int): Array[Int] = {
    if (k == 0) {
      Array.emptyIntArray
    } else if (k == 1) {
      nums
    } else if (k == nums.length) {
      val ans = new Array[Int](1)
      ans(0) = nums.max
      ans
    } else {
      val ans = new Array[Int](nums.length - k + 1)
      var maxIndex = 0
      var max = nums(0)
      val after = new mutable.Queue[(Int, Int)]() //only need two

      for (i <- nums.indices) {
        if (maxIndex + k <= i) {
          val second = after.dequeue()
          max = second._1
          maxIndex = second._2
        }

        val n = nums(i)
        println(n)
        if (n >= max) {
          max = n
          maxIndex = i
          after.clear()
        } else if (after.nonEmpty) {
          val second = after.head
          if (n >= second._1) {
            after.clear()
            after.enqueue((n, i))
          } else {
            val last = after.last
            if (n > last._1) {
              after.dropRight(1)
              after.enqueue((n, i))
            }
          }
        } else {
          after.enqueue((n, i))
        }
        val index = i + 1 - k
        if (index >= 0) {
          ans(index) = max
          println("====" + max)
        }
      }
      ans
    }
  }
}

