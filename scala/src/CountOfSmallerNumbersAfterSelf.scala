import java.util

/** 315. Count of Smaller Numbers After Self
  * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
  * Example: Input: [5,2,6,1]  Output: [2,1,1,0]
  * Explanation:
  * To the right of 5 there are 2 smaller elements (2 and 1).
  * To the right of 2 there is only 1 smaller element (1).
  * To the right of 6 there is 1 smaller element (1).
  * To the right of 1 there is 0 smaller element.
  */
object CountOfSmallerNumbersAfterSelf {
  def countSmaller(nums: Array[Int]): List[Int] = {
    if (nums.nonEmpty) {
      val array = new Array[Int](nums.length)
      val tails = new util.LinkedList[Int]()
      for (i <- nums.indices.reverse) {
        val num = nums(i)
        var index = 0
        var loop = true
        val iterator = tails.iterator()
        while (loop & iterator.hasNext) {
          val next = iterator.next()
          if (next >= num)
            loop = false
          else
            index += 1
        }
        array(i) = index
        tails.add(index, num)
      }
      array.toList
    } else Nil
  }
}
