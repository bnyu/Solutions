import scala.collection.mutable

/** 211. Add and Search Word - Data structure design
  * Design a data structure that supports the following two operations:
  * void addWord(word)
  * bool search(word)
  * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
  * Example:
  * addWord("bad")
  * addWord("dad")
  * search(".ad") -> true
  * search("b..") -> true
  * Note: You may assume that all words are consist of lowercase letters a-z.
  */
class WordDictionary() {
  private val words = new mutable.HashMap[Int, mutable.HashSet[String]]()

  private def matching(word: String, dictionary: String): Boolean = {
    var matched = true
    for (i <- word.indices if matched && word(i) != '.') {
      if (word(i) != dictionary(i))
        matched = false
    }
    matched
  }

  /** Adds a word into the data structure. */
  def addWord(word: String): Unit = {
    val set = words.getOrElseUpdate(word.length, new mutable.HashSet[String]())
    set.add(word)
  }

  /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
  def search(word: String): Boolean = {
    val set = words.get(word.length)
    set.isDefined && set.get.exists(p => matching(word, p))
  }

}
