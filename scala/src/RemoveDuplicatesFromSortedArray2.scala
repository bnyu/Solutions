/** 80. Remove Duplicates from Sorted Array II
  * Follow up for "Remove Duplicates": What if duplicates are allowed at most twice?
  * For example, Given sorted array nums = [1,1,1,2,2,3], Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
  */
object RemoveDuplicatesFromSortedArray2 {
  def removeDuplicates(nums: Array[Int]): Int = {
    val mostTimes = 2
    val size = nums.length
    if (size <= mostTimes) size else {
      var previous = nums(0)
      var lastIndex = 0
      var dupNum = 1
      for (i <- 1 until size) {
        if (nums(i) == previous) {
          dupNum += 1
          if (dupNum <= mostTimes) {
            lastIndex += 1
            nums(lastIndex) = previous
          }
        } else {
          previous = nums(i)
          lastIndex += 1
          nums(lastIndex) = previous
          dupNum = 1
        }
      }
      lastIndex + 1
    }
  }
}
