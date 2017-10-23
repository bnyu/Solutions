/** 171. Excel Sheet Column Number
  * Related to question Excel Sheet Column Title
  * Given a column title as appear in an Excel sheet, return its corresponding column number.
  * For example:
  * A -> 1
  * B -> 2
  * ...
  * Z -> 26
  * AA -> 27
  * AB -> 28
  */
object ExcelSheetColumnNumber {
  def titleToNumber(s: String): Int = {
    var sum = 0
    var i = 1
    for (c <- s.reverse) {
      val x = c - 'A' + 1
      sum += (i * x)
      i *= 26
    }
    sum
  }
}
