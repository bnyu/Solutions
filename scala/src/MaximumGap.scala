/** 164. Maximum Gap
  * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
  * Try to solve it in linear time/space.
  * Return 0 if the array contains less than 2 elements.
  * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
  */
object MaximumGap {
  def maximumGap(nums: Array[Int]): Int = {
    if (nums.length > 1) {
      val sorted = nums.sorted //cheat
      var maxGap = 0
      var pre = sorted.head
      sorted.foreach(n => {
        val gap = n - pre
        if (gap > maxGap)
          maxGap = gap
        pre = n
      })
      maxGap
    } else 0
  }
}
