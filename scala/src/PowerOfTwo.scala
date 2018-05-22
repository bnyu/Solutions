/** 231. Power of Two
  * Given an integer, write a function to determine if it is a power of two.
  * Example 1: Input: 1  Output: true
  * Example 2: Input: 16  Output: true
  */
object PowerOfTwo {
  def isPowerOfTwo(n: Int): Boolean = {
    if (n > 1) {
      var p = 1 //power
      var x = 1 //num
      while (n > p) {
        x = x << 1
        p = p << 2
      }
      var is = false
      var a = x >> 1
      var b = x
      while (!is && b - a > 1) {
        val i = (a + b) >> 1
        val p = i * i
        if (p == n) is = true
        else if (p > n) b = i
        else a = i
      }
      is || a * a == n || b * b == n
    } else n == 0 || n == 1
  }
}
