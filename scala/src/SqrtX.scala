/** 69. Sqrt(x)
  * Implement int sqrt(int x). Compute and return the square root of x. x is guaranteed to be a non-negative integer.
  */
object SqrtX {
  def mySqrt(x: Int): Int = {
    if (x <= 0) 0 else {
      var n1 = 1
      while (x / n1 > n1)
        n1 *= 2
      var n0 = n1 / 2
      //n in (n0, n1]
      while (x / n1 < n1)
        n1 = (n0 + n1) / 2
      while (x / n1 >= n1)
        n1 += 1
      n1 - 1
    }
  }
}
