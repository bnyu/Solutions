import scala.collection.mutable

/** 198. House Robber
  * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
  * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
  * Example :Input: [2,7,9,3,1] Output: 12
  * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
  * Total amount you can rob = 2 + 9 + 1 = 12.
  */
object HouseRobber {
  def rob(nums: Array[Int]): Int = {
    // similar with 174.Dungeon Game
    val cache = new mutable.HashMap[Int, Int]()

    def rob(index: Int): Int = {
      if (index >= nums.length)
        0
      else {
        cache.getOrElseUpdate(index, {
          val m1 = rob(index + 1)
          val m2 = rob(index + 2) + nums(index)
          if (m1 > m2) m1 else m2
        })
      }
    }

    rob(0)
  }
}
