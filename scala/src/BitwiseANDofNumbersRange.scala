/** 201. Bitwise AND of Numbers Range
  * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
  * Example: Input: [5,7] Output: 4
  */
object BitwiseANDofNumbersRange {
  def rangeBitwiseAnd(m: Int, n: Int): Int = {
    //only 3 kinds:if m equal n,else if has same highest bit, else 0
    if (m == 0)
      0
    else if (m == n) {
      m
    } else {
      def highestBit(n: Int): Int = {
        var x = n
        var i = 0
        while (x != 0) {
          x = x >> 1
          i += 1
        }
        1 << (i - 1)
      }

      val x1 = highestBit(n)
      val x2 = highestBit(m)
      x1 & x2
    }
  }
}
