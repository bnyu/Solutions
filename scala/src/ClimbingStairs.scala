import scala.collection.mutable

/** 70. Climbing Stairs
  * You are climbing a stair case. It takes n steps to reach to the top.
  * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
  * Note: Given n will be a positive integer.
  */
object ClimbingStairs {
  def climbStairs(n: Int): Int = {
    val cache = mutable.HashMap[Int, Int]()

    //n:剩余阶梯数 x:已走步数
    def climb(n: Int, x: Int): Int = if (n < 0) x else {
      // 上一步加上上上步
      val steps = x + cache.getOrElse(n + 2, 0)
      cache.update(n, steps)
      //接着走下一步
      climb(n - 1, steps)
    }

    if (n > 0) climb(n, 1) else 0
  }
}
