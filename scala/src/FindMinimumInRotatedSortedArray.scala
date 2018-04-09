/** 153. Find Minimum in Rotated Sorted Array
  * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
  * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
  * Find the minimum element.
  * You may assume no duplicate exists in the array.
  */
object FindMinimumInRotatedSortedArray {
  //similar with 33. Search in Rotated Sorted Array
  def findMin(nums: Array[Int]): Int = {
    if (nums.nonEmpty) {
      if (nums.length > 1 && nums(0) > nums(nums.length - 1)) {
        var first = 0
        var last = nums.length - 1
        while (last - first > 1) {
          val mid = (first + last) / 2
          if (nums(mid) > nums(first))
            first = mid
          else last = mid
        }
        if (nums(first) > nums(last)) nums(last) else nums(first)
      } else nums.head
    } else 0
  }
}
