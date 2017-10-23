import scala.collection.mutable

/** 168. Excel Sheet Column Title
  * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
  * For example:
  * 1 -> A
  * 2 -> B
  * ...
  * 26 -> Z
  * 27 -> AA
  * 28 -> AB
  */
object ExcelSheetColumnTitle {
  def convertToTitle(n: Int): String = {
    //if A represent 0, Z represent 25; then what does AA mean?
    //eg. 3-ary system
    //0: 0 -> 1      //so think this
    //1: 1 -> 2       -> 1
    //2: 2 -> 3       -> 2
    //3: 10 -> 11     -> 3
    //4: 11 -> 12     -> 11
    //5: 12 -> 13     -> 12
    //6: 20 -> 21     -> 13
    //7: 21 -> 22     -> 21
    //8: 22 -> 23     -> 22
    //9: 100 -> 31    -> 23
    //10: 101 -> 32   -> 31
    //11: 102 -> 33   -> 32
    //12: 110 -> 111  -> 33
    //13: 111 -> 112  -> 111
    if (n <= 0)
      return ""
    var num = n
    val list = new mutable.MutableList[Int]
    while (num > 26) {
      val x = num % 26
      if (x > 0) {
        x +=: list
        num /= 26
      } else {
        26 +=: list
        num = (num - 1) / 26
      }
    }
    if (num > 0)
      num +=: list
    else
      1 +=: list

    list.map(n => (n - 1 + 'A').toChar).mkString
  }
}

