/** 88. Merge Sorted Array
  * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
  * Note: You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
  */
object MergeSortedArray {
  def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit = {
    var i = 0
    var i2 = 0
    var i1 = m

    def insert(num: Int): Unit = {
      for (k <- (i until i2 + m).reverse)
        nums1(k + num) = nums1(k)
      for (k <- 0 until num)
        nums1(i + k) = nums2(i2 + k)
      i2 += num
      i += num
    }

    while (i2 < n) {
      if (i1 > 0) {
        val num = nums1(i)
        var insertNum = 0
        var break = false
        for (j <- i2 until n if !break) {
          if (nums2(j) < num)
            insertNum += 1
          else break = true
        }
        if (insertNum > 0)
          insert(insertNum)
        i += 1
        i1 -= 1
      } else {
        for (k <- 0 until n - i2)
          nums1(i + k) = nums2(i2 + k)
        i2 = n
      }
    }
  }
}
