/** 67. Add Binary
  * Given two binary strings, return their sum (also a binary string).
  * For example, a = "11" b = "1" Return "100".
  */
object AddBinary {
  def addBinary(a: String, b: String): String = {
    val zero = '0'
    var index = 0
    var carry = 0

    def plus(): Int = {
      index += 1
      val num = if (index <= a.length) a.charAt(a.length - index) - zero else 0
      val num1 = if (index <= b.length) b.charAt(b.length - index) - zero else 0
      val sum = num + num1 + carry
      carry = sum / 2
      sum % 2
    }

    val binary = Array.fill(Math.max(a.length, b.length) + 1)(plus())
    val str = binary.reverse.dropWhile(_ == 0).foldLeft("")(_ + _)
    if (str.nonEmpty) str else zero.toString
  }
}
