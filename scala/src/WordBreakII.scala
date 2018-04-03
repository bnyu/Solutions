import scala.collection.mutable

/** 140. Word Break II
  * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. You may assume the dictionary does not contain duplicate words.
  * Return all such possible sentences.
  * For example, given: s = "catsanddog", dict = ["cat", "cats", "and", "sand", "dog"]. A solution is ["cats and dog", "cat sand dog"].
  */
object WordBreakII {
  def wordBreak(s: String, wordDict: List[String]): List[String] = {
    val ans = new mutable.MutableList[String]
    val wordMap = new mutable.HashMap[Int, String]

    def isValid(index: Int, word: String): Boolean = {
      if (index + word.length <= s.length) {
        var valid = true
        var i = 0
        for (c <- word if valid) {
          if (c != s.charAt(index + i))
            valid = false
          i += 1
        }
        valid
      } else false
    }

    def splice(index: Int, order: Int): Unit = {
      if (index < s.length) {
        for (word <- wordDict) {
          if (isValid(index, word)) {
            wordMap.update(order, word)
            splice(index + word.length, order + 1)
          }
        }
        wordMap.remove(order)
      } else {
        ans += wordMap.toList.sortBy(_._1).map(_._2).mkString(" ")
      }
    }

    splice(0, 0)
    ans.toList
  }
}

