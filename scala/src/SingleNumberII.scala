import scala.collection.mutable

/** 137. Single Number II
  * Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
  * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
  */
object SingleNumberII {
  def singleNumber(nums: Array[Int]): Int = {
    val numbers = new mutable.HashMap[Int, Int]()
    nums.foreach(n =>
      numbers.update(n, numbers.getOrElse(n, 0) + 1)
    )
    numbers.find(_._2 == 1).get._1
  }
}
