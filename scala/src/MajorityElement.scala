/** 169. Majority Element
  * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
  * You may assume that the array is non-empty and the majority element always exist in the array.
  */
object MajorityElement {
  def majorityElement(nums: Array[Int]): Int = {
    quickSort(nums)
    nums(nums.length / 2)
  }

  def quickSort[T <% Ordered[T]](a: Array[T]): Unit = {
    if (a.length > 1) {
      def sort(start: Int, end: Int): Unit = {
        var i = start
        var k = end
        val mid = a(k)
        while (i < k) {
          while (i < k && mid >= a(i))
            i += 1
          if (i < k)
            a(k) = a(i)
          while (i < k && mid <= a(k))
            k -= 1
          if (i < k)
            a(i) = a(k)
          a(k) = mid
        }
        if (k - 1 > start)
          sort(start, k - 1)
        if (k + 1 < end)
          sort(k + 1, end)
      }

      sort(0, a.length - 1)
    }
  }
}
