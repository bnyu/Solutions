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
      val subs = Array.fill(t.length)(0)
      val subs1 = Array.fill(t.length)(0)

      for (i <- s.indices) {
        val c = s(i)
        for (j <- 0 to i if j < t.length && s.length - i >= t.length - j)
          if (c == t(j))
            subs1(j) = if (j == 0) 1 else subs(j - 1)

        t.indices.foreach(i => {
          subs(i) += subs1(i)
          subs1(i) = 0
        })
      }
      subs.last
    } else 0
  }
}
