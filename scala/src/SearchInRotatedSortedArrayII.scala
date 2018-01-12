import scala.collection.mutable

/** 81. Search in Rotated Sorted Array II
  * Follow up for "Search in Rotated Sorted Array": What if duplicates are allowed? Would this affect the run-time complexity? How and why?
  * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
  * Write a function to determine if a given target is in the array.The array may contain duplicates.
  */
object SearchInRotatedSortedArrayII {
  def search(nums: Array[Int], target: Int): Boolean = {
    var i = 0
    var j = nums.length - 1
    if (j < i)
      return false
    val head = nums(i)
    if (head == target)
      return true

    j = if (nums(i) < nums(j)) i else if (nums(i) > nums(j)) j else {
      // eg: 4,4,4,4,4,7,4,4,4
      def search(s: mutable.MutableList[(Int, Int)]): Int = {
        val nextS = mutable.MutableList[(Int, Int)]()
        var x = 0
        for ((i, j) <- s if x == 0) {
          x = if (nums(i) != head) i else if (nums(j) != head) j else {
            val mid = (i + j) / 2
            if (mid > i) nextS += ((i + 1, mid))
            if (mid < j) nextS += ((mid + 1, j - 1))
            0
          }
        }
        if (x != 0 || nextS.isEmpty) x else search(nextS)
      }

      val s = mutable.MutableList((i + 1, j - 1))
      search(s)
    }
    //todo

    if (nums(j) > head) {
      val temp = j
      j = i
      i = temp
    }

    //todo

    val tail = nums(j)
    while (j - i > 1) {
      val mid = (i + j) / 2
      if (nums(mid) >= tail) i = mid else j = mid
    }
    val rotate = if (nums(j) >= tail) j else i

    //todo
    ???
  }
}

