import scala.collection.mutable

/** 205. Isomorphic Strings
  * Given two strings s and t, determine if they are isomorphic.
  * Two strings are isomorphic if the characters in s can be replaced to get t.
  * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
  * Example 1: Input: s = "egg", t = "add"  Output: true
  * Example 2: Input: s = "foo", t = "bar"  Output: false
  * Note: You may assume both s and t have the same length.
  */
object IsomorphicStrings {
  def isIsomorphic(s: String, t: String): Boolean = {
    val s2tMap = new mutable.HashMap[Char, Char]()
    val t2sMap = new mutable.HashMap[Char, Char]()
    var same = s.length == t.length
    for (i <- s.indices if same) {
      val sc = s(i)
      val tc = t(i)
      val s2t = s2tMap.getOrElseUpdate(sc, t(i))
      val t2s = t2sMap.getOrElseUpdate(tc, s(i))
      same = sc == t2s && tc == s2t
    }
    same
  }
}
