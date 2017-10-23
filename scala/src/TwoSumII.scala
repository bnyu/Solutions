/** 167. Two Sum II - Input array is sorted
  * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
  * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
  * You may assume that each input would have exactly one solution and you may not use the same element twice.
  * Input: numbers={2, 7, 11, 15}, target=9  Output: index1=1, index2=2
  */
object TwoSumII {
  def twoSum(numbers: Array[Int], target: Int): Array[Int] = {
    var i = 0
    var j = numbers.length - 1
    var loop = true
    while (i < j && loop) {
      val n = numbers(i) + numbers(j)
      if (n > target)
        j -= 1
      else if (n < target)
        i += 1
      else
        loop = false
    }
    Array(i + 1, j + 1)
  }
}
