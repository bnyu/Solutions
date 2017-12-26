/** 70. Climbing Stairs
  * You are climbing a stair case. It takes n steps to reach to the top.
  * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
  * Note: Given n will be a positive integer.
  */
object ClimbingStairs {
  def climbStairs(n: Int): Int = {
    //n:剩余阶梯数 x:到这步总数 x0:上一步时总数 (Fibonacci sequence)
    def climb(n: Int, x: Int, x0: Int): Int = if (n == 0) x else climb(n - 1, x + x0, x)

    if (n > 2) climb(n - 2, 2, 1) else if (n == 2) 2 else if (n == 1) 1 else 0
  }
}
