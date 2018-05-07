import scala.collection.mutable

/** 213. House Robber II
  * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
  * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
  * Example 1: Input: [2,3,2]  Output: 3
  * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
  * because they are adjacent houses.
  * Example 2: Input: [1,2,3,1]  Output: 4
  * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
  * Total amount you can rob = 1 + 3 = 4.
  */
object HouseRobberII {
  def rob(nums: Array[Int]): Int = {
    val cache = new mutable.HashMap[Int, Int]()

    def rob(from: Int, to: Int): Int = {
      if (from > to) {
        0
      } else {
        cache.getOrElseUpdate(from, {
          val m1 = rob(from + 1, to)
          val m2 = rob(from + 2, to) + nums(from)
          if (m1 > m2) m1 else m2
        })
      }
    }

    if (nums.length > 2) {
      val m1 = rob(0, nums.length - 2)
      cache.clear()
      val m2 = rob(1, nums.length - 1)
      if (m1 > m2) m1 else m2
    } else if (nums.length == 1) {
      nums(0)
    } else 0
  }
}
