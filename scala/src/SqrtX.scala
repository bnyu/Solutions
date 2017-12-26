/** 69. Sqrt(x)
  * Implement int sqrt(int x). Compute and return the square root of x. x is guaranteed to be a non-negative integer.
  */
object SqrtX {
  def mySqrt(x: Int): Int = {
    if (x <= 0) 0 else {
      var n = 1
      while (x / n > n)
        n *= 2
      while (x / n < n)
        n -= 1
      n
    }
  }
}
