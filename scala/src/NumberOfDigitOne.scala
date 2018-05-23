import scala.collection.mutable

/** 233. Number of Digit One
  * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
  * Example: Input: 13  Output: 6  Explanation: Digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
  */
object NumberOfDigitOne {
  //1  ...   11 21  31  41  51  61  71  81  91 100 ...  101   111 121 131 141 ... 201 ...
  //     10 11 12 13 14 15 16 17 18 19                   111 112 113 ...
  def countDigitOne(n: Int): Int = {
    var sum1 = 0
    if (n > 0) {
      val num1s = new mutable.ArrayStack[(Int, Int)]()
      var preX = 1
      var x = 1
      var i = 0
      while (n >= x) {
        val num = i * preX
        num1s.push(x, num)
        preX = x
        x *= 10
        i += 1
      }
      var num = n
      while (i > 0) {
        val (x1, num1) = num1s.pop()
        val d = num / x1
        num -= d * x1
        if (d > 1) {
          sum1 += x1 + num1 * d
        } else if (d == 1) {
          sum1 += num1 + num + 1
        }
        i -= 1
      }
    }
    sum1
  }
}
