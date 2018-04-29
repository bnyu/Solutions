/** 201. Bitwise AND of Numbers Range
  * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
  * Example: Input: [5,7] Output: 4
  */
object BitwiseANDofNumbersRange {
  def rangeBitwiseAnd(m: Int, n: Int): Int = {
    //only 3 kinds:if m equal n,else if has same highest bits, else 0
    if (m == 0)
      0
    else if (m == n) {
      m
    } else {
      def highestBits(n: Int): Int = {
        var x = n
        var i = 0
        while (x != 0) {
          x = x >> 1
          i += 1
        }
        x = 1 << (i - 1)
        while (i > 1) {
          i -= 1
          val y = x | (x >> 1)
          if ((y & n) == y)
            x = y
          else
            i = 0
        }
        x
      }

      val x1 = highestBits(n)
      val x2 = highestBits(m)
      x1 & x2
    }
  }
}
