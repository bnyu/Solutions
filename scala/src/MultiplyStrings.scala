/** 43. Multiply Strings
  * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
  * Example 1:
  * Input: num1 = "2", num2 = "3"
  * Output: "6"
  * Example 2:
  * Input: num1 = "123", num2 = "456"
  * Output: "56088"
  * Note:
  * The length of both num1 and num2 is < 110.
  * Both num1 and num2 contain only digits 0-9.
  * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
  * You must not use any built-in BigInteger library or convert the inputs to integer directly.
  */

object MultiplyStrings {
  def multiply(num1: String, num2: String): String = {
    var tail = ""
    var s0 = ""
    for (c1 <- num1.reverse) {
      val n1 = c1 - '0'
      val s1 = if (n1 == 0) {
        "0"
      } else if (n1 == 1) {
        num2
      } else {
        var n0 = 0
        var s0 = ""
        for (c2 <- num2.reverse) {
          val n2 = c2 - '0'
          val sum = n0 + n1 * n2
          n0 = sum / 10
          s0 = sum - 10 * n0 + s0
        }
        if (n0 > 0) {
          s0 = n0 + s0
        }
        s0
      }
      s0 = add(s1 + tail, s0)
      tail += '0'
    }
    s0 = s0.dropWhile(_ == '0')
    if (s0.length != 0) {
      s0
    } else {
      "0"
    }
  }

  def add(num1: String, num2: String): String = {
    val l = if (num1.length > num2.length) num1.length else num2.length
    var n0 = 0
    var s0 = ""
    for (i <- 1 to l) {
      val n1 = if (i <= num1.length) num1(num1.length - i) - '0' else 0
      val n2 = if (i <= num2.length) num2(num2.length - i) - '0' else 0
      val sum = n0 + n1 + n2
      n0 = sum / 10
      s0 = sum - 10 * n0 + s0
    }
    if (n0 > 0) {
      s0 = n0 + s0
    }
    s0
  }
}
