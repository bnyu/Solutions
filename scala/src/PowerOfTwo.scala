/** 231. Power of Two
  * Given an integer, write a function to determine if it is a power of two.
  * Example 1: Input: 1  Output: true
  * Example 2: Input: 16  Output: true
  */
object PowerOfTwo {
  def isPowerOfTwo(n: Int): Boolean = {
    if (n > 0) {
      var p = 1
      var num = 0
      for (_ <- 1 to 32) {
        if ((p & n) == p) num += 1
        p = p << 1
      }
      num == 1
    } else false
  }
}
