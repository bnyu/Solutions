/** 115. Distinct Subsequences
  * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
  * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
  * Example 1:
  * Input: S = "rabbbit", T = "rabbit"; Output: 3
  * Explanation: As shown below, there are 3 ways you can generate "rabbit" from S.
  * rabbbit
  * ^^^^ ^^
  * rabbbit
  * ^^ ^^^^
  * rabbbit
  * ^^^ ^^^
  */
object DistinctSubsequences {
  def numDistinct(s: String, t: String): Int = {
    if (t.length > 0 && s.length >= t.length) {

      def subs(si: Int, ti: Int): Int = {
        var n = 0
        if (ti == t.length - 1) n = 1 else for (si <- si + 1 until s.length if t(ti + 1) == s(si)) n += subs(si, ti + 1)
        n
      }

      var n = 0
      for (i <- s.indices if s(i) == t(0)) n += subs(i, 0)
      n
    } else 0
  }
}
