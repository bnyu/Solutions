/** 208. Implement Trie (Prefix Tree)
  * Implement a trie with insert, search, and startsWith methods.
  * Note: You may assume that all inputs are consist of lowercase letters a-z.
  */
class Trie {

  class Node(var isTail: Boolean = false) {
    val next: Array[Node] = new Array[Node](26)
  }

  val root = new Node()

  /** Inserts a word into the trie. */
  def insert(word: String): Unit = {
    var pre = root
    for (c <- word) {
      val i = c - 'a'
      if (i >= 0 && i < 26) {
        var node = pre.next(i)
        if (node == null) {
          node = new Node()
          pre.next(i) = node
        }
        pre = node
      }
    }
    pre.isTail = true
  }

  /** Returns if the word is in the trie. */
  def search(word: String): Boolean = {
    val tail = searchTailNode(word)
    tail != null && tail.isTail
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  def startsWith(prefix: String): Boolean = {
    val tail = searchTailNode(word = prefix)
    tail != null
  }

  private def searchTailNode(word: String): Node = {
    var exist = true
    var index = 0
    var pre = root
    while (exist && index < word.length) {
      val c = word(index)
      val i = c - 'a'
      if (i >= 0 && i < 26) {
        val node = pre.next(i)
        if (node == null)
          exist = false
        else
          pre = node
      } else exist = false
      index += 1
    }
    if (exist)
      pre
    else null
  }

}

