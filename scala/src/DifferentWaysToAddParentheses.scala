import scala.collection.mutable

/** 241. Different Ways to Add Parentheses
  * Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.
  * Example : Input: "2*3-4*5"  Output: [-34, -14, -10, -10, 10]
  * Explanation:
  * (2*(3-(4*5))) = -34
  * ((2*3)-(4*5)) = -14
  * ((2*(3-4))*5) = -10
  * (2*((3-4)*5)) = -10
  * (((2*3)-4)*5) = 10
  */
object DifferentWaysToAddParentheses {
  def diffWaysToCompute(input: String): List[Int] = {
    type OP = (Int, Int) => Int
    val multi: OP = _ * _
    val plus: OP = _ + _
    val minus: OP = _ - _
    val operators = new mutable.MutableList[OP]()
    val result = new mutable.HashMap[(Int, Int), List[Int]]()

    var num = 0
    var i = 0
    for (c <- input) {
      val n = c - '0'
      if (n >= 0 && n <= 9) {
        num *= 10
        num += n
      } else {
        val op = c match {
          case '*' => multi
          case '+' => plus
          case '-' => minus
        }
        operators.+=(op)
        result.put((i, i), List(num))
        num = 0
        i += 1
      }
    }
    result.put((i, i), List(num))

    def calculate(start: Int, end: Int): List[Int] = {
      result.getOrElseUpdate((start, end), {
        val res = new mutable.MutableList[Int]
        for (i <- start until end) {
          val op = operators(i)
          val left = calculate(start, i)
          val right = calculate(i + 1, end)
          for (a <- left; b <- right)
            res.+=(op(a, b))
        }
        res.toList
      })
    }

    calculate(0, i)
  }
}
