/** 66. Plus One
  * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
  * You may assume the integer do not contain any leading zero, except the number 0 itself.
  * The digits are stored such that the most significant digit is at the head of the list.
  */
object PlusOne {
  def plusOne(digits: Array[Int]): Array[Int] = {
    var carry = 1
    var index = digits.length

    def plus(): Int = {
      index -= 1
      if (index >= 0) {
        if (carry != 0) {
          val sum = digits(index) + carry
          carry = sum / 10
          sum % 10
        } else digits(index)
      } else carry
    }

    val pulsed = Array.fill(digits.length + 1)(plus())
    pulsed.reverse.dropWhile(_ == 0)
  }
}

