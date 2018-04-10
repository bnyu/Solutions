import scala.collection.mutable

/** 150. Evaluate Reverse Polish Notation
  * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
  * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
  * Some examples: ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9;  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
  */
object EvaluateReversePolishNotation {
  def evalRPN(tokens: Array[String]): Int = {
    type Op = (Int, Int) => Int
    var operations = new mutable.MutableList[(Op, Option[Int])]
    val plus: Op = _ + _
    val minus: Op = _ - _
    val multi: Op = _ * _
    val divide: Op = _ / _
    var result: Option[Int] = None
    for (t <- tokens.reverse if result.isEmpty) {
      t match {
        case "+" => operations += ((plus, None))
        case "-" => operations += ((minus, None))
        case "*" => operations += ((multi, None))
        case "/" => operations += ((divide, None))
        case num =>
          var n = num.toInt
          var loop = true
          while (loop && operations.nonEmpty) {
            val (op, b) = operations.last
            if (b.isEmpty) {
              operations(operations.length - 1) = (op, Some(n))
              loop = false
            } else {
              n = op(n, b.get) //n = a op b; n作为下一个op的b或a(若已存在b)
              operations = operations.dropRight(1)
            }
          }
          if (operations.isEmpty)
            result = Some(n)
      }
    }
    result.getOrElse(0)
  }
}

