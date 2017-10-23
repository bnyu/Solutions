/** 227. Basic Calculator II
  * Implement a basic calculator to evaluate a simple expression string.
  * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
  * Example : Input: " 3+5 / 2 "  Output: 5
  * Note: You may assume that the given expression is always valid. Do not use the eval built-in library function.
  */
object BasicCalculatorII {
  def calculate(s: String): Int = {
    type OP = (Int, Int) => Int
    val plus: OP = _ + _
    val minus: OP = _ - _
    val multi: OP = _ * _
    val divide: OP = _ / _
    var prioritize = false
    var preOp = plus
    var op = plus
    var sum = 0
    var num = 0
    var n = 0
    for (c <- s if c != ' ') {
      if (c >= '0' && c <= '9') {
        n = 10 * n + c - '0'
      } else {
        if (c == '+' || c == '-') {
          if (prioritize) {
            num = op(num, n)
            sum = preOp(sum, num)
            prioritize = false
          } else {
            sum = op(sum, n)
          }
          op = if (c == '+') plus else minus
        } else if (c == '*' || c == '/') {
          if (prioritize) {
            num = op(num, n)
          } else {
            num = n
            preOp = op
            prioritize = true
          }
          op = if (c == '*') multi else divide
        }
        n = 0
      }
    }
    if (prioritize) {
      num = op(num, n)
      sum = preOp(sum, num)
    } else {
      sum = op(sum, n)
    }
    sum
  }
}
