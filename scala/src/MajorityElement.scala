/** 169. Majority Element
  * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
  * You may assume that the array is non-empty and the majority element always exist in the array.
  */
object MajorityElement {
  def majorityElement(nums: Array[Int]): Int = {
    insertSort(nums)
    nums(nums.length / 2)
  }

  def insertSort(a: Array[Int]): Unit = {
    if (a.length > 1) {
      for (i <- 1 until a.length) {
        val toInsert = a(i)
        var k = i - 1
        while (k >= 0 && toInsert < a(k))
          k -= 1
        k += 1
        if (k < i) {
          for (m <- (k until i).reverse)
            a(m + 1) = a(m)
          a(k) = toInsert
        }
      }
    }
  }
}
