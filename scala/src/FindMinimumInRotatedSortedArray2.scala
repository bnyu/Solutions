import scala.collection.mutable

/** 154. Find Minimum in Rotated Sorted Array II
  * Follow up for "Find Minimum in Rotated Sorted Array":
  * What if duplicates are allowed?
  * Would this affect the run-time complexity? How and why?
  */
object FindMinimumInRotatedSortedArray2 {
  def findMin(nums: Array[Int]): Int = {
    if (nums.nonEmpty) {
      var first = 0
      var last = nums.length - 1
      var min = nums.head
      var loop = true
      while (loop) {
        loop = false
        if (last - first > 0 && nums(first) > nums(last)) {
          while (last - first > 1) {
            val mid = (first + last) / 2
            if (nums(mid) >= nums(first))
              first = mid
            else last = mid
          }
          min = if (nums(first) > nums(last)) nums(last) else nums(first)
        } else if (last - first > 0 && nums(first) == nums(last)) { //only difference
          val start = nums.head
          val parts = new mutable.Queue[(Int, Int)]()
          parts.enqueue((first, last))
          while (parts.nonEmpty) {
            val (from, to) = parts.dequeue()
            val mid = (from + to) / 2
            if (nums(mid) == start) {
              if (mid - from > 1)
                parts.enqueue((from, mid))
              if (to - mid > 1)
                parts.enqueue((mid, to))
            } else {
              loop = true
              parts.clear()
              if (nums(mid) > start) {
                first = mid
                last = to
              } else {
                first = from
                last = mid
              }
            }
          }
        }
      }
      min
    } else 0
  }
}
