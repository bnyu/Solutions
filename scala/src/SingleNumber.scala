import scala.collection.mutable

/** 136. Single Number
  * Given an array of integers, every element appears twice except for one. Find that single one.
  * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
  */
object SingleNumber {
  def singleNumber(nums: Array[Int]): Int = {
    val numbers = new mutable.HashMap[Int, Boolean]()
    nums.foreach(n => {
      if (numbers.contains(n))
        numbers.update(n, false)
      else
        numbers.update(n, true)
    })
    numbers.find(_._2).get._1
  }
}
