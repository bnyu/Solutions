/** 139. Word Break
  * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.
  * For example, given: s = "leetcode",  dict = ["leet", "code"].
  * Return true because "leetcode" can be segmented as "leet code".
  */
object WordBreak {
  def wordBreak(s: String, wordDict: List[String]): Boolean = {
    val charSet = s.toSet
    val words = wordDict.sortBy(_.length).reverse
    val wordChar = words.flatMap(s => s.toSet)
    var valid = true
    for (c <- charSet if valid) {
      if (!wordChar.contains(c))
        valid = false
    }
    if (valid) {
      def isValid(index: Int, word: String): Boolean = {
        if (index + word.length <= s.length)
          s.substring(index, index + word.length) == word
        else false
      }

      def splice(index: Int): Boolean = {
        if (index < s.length) {
          var valid = false
          for (word <- words if !valid) {
            if (isValid(index, word))
              valid = splice(index + word.length)
          }
          valid
        } else true
      }

      splice(0)
    } else false
  }
}
