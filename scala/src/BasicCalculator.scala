import scala.collection.mutable

/** 224. Basic Calculator
  * Implement a basic calculator to evaluate a simple expression string.
  * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
  * Example :
  * Input: "(1+(4+5+2)-3)+(6+8)"
  * Output: 23
  * Note: You may assume that the given expression is always valid. Do not use the eval built-in library function.
  */
object BasicCalculator {
  def calculate(s: String): Int = {
    //similar with 150.
    var sum = 0
    type OP = (Int, Int) => Int
    val plus: OP = _ + _
    val minus: OP = _ - _
    var op = plus
    val ops = new mutable.ArrayStack[(Int, OP)]()
    ops.push(0, plus)
    var n = 0
    for (c <- s) {
      if (c >= '0' && c <= '9') {
        n = 10 * n + (c - '0')
      } else if (c != ' ') {
        if (c == '+') {
          sum = op(sum, n)
          op = plus
        } else if (c == '-') {
          sum = op(sum, n)
          op = minus
        } else if (c == '(') {
          ops.push(sum, op)
          sum = 0
          op = plus
        } else if (c == ')') {
          sum = op(sum, n)
          val (pre, act) = ops.pop
          sum = act(pre, sum)
        }
        n = 0
      }
    }
    sum = op(sum, n)
    sum
  }
}
