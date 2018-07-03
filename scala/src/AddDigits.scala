/** 258. Add Digits
  * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
  * Example: Input: 38  Output: 2
  * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
  * Since 2 has only one digit, return it.
  * Follow up: Could you do it without any loop/recursion in O(1) runtime?
  */
object AddDigits {
  def addDigits(num: Int): Int = {
    val digits = Array.fill(9)(10)
    digits.indices.tail.foreach(i => digits(i) *= digits(i - 1))
    var n = num
    while (n >= 10) {
      var sum = 0
      for (i <- digits.reverse) {
        val x = n / i
        n = n - x * i
        sum += x
      }
      n += sum
    }
    n
  }
}