import scala.collection.mutable

/**
  * The goal of this exercise is to convert a string to a new string where each character in the new string is '(' if that character appears only once in the original string,
  * or ')' if that character appears more than once in the original string. Ignore capitalization when determining if a character is a duplicate.
  */
object DuplicateEncoder {
  def duplicateEncode(word: String) = {
    val str = word.toLowerCase
    val characters = mutable.HashMap[Char, Int]()
    val sList = mutable.MutableList.fill(str.length)('(')
    for (i <- 0 until str.length) {
      val c = str(i)
      val index = characters.get(c)
      if (index.isDefined) {
        sList(index.get) = ')'
        sList(i) = ')'
      } else {
        characters(c) = i
      }
    }
    sList.foldLeft("")((s, c) => s + c)
  }
}
