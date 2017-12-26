import scala.collection.mutable

/** 70. Climbing Stairs
  * You are climbing a stair case. It takes n steps to reach to the top.
  * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
  * Note: Given n will be a positive integer.
  */
object ClimbingStairs {
  def climbStairs(n: Int): Int = {
    val cache = mutable.HashMap[Int, Int]()

    def climb(n: Int): Int = {
      if (n < 0) 0 else if (n == 0) 1 else cache.getOrElseUpdate(n, climb(n - 2) + climb(n - 1))
    }

    climb(n)
  }
}
