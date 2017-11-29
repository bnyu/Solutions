/**
  * 58. Length of Last Word
  * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
  * If the last word does not exist, return 0.
  */
object LengthOfLastWord {
  def lengthOfLastWord(s: String): Int = {
    val end = s.lastIndexWhere(_ != ' ')
    val start = s.lastIndexOf(' ', end)
    end - start
  }
}
