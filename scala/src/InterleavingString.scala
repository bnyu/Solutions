/** 97. Interleaving String
  * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
  * For example, Given: s1 = "aabcc", s2 = "dbbca", When s3 = "aadbbcbcac", return true. When s3 = "aadbbbaccc", return false.
  */
object InterleavingString {
  def isInterleave(s1: String, s2: String, s3: String): Boolean = {

    def interChar(i1: Int, i2: Int, i3: Int): Boolean = {
      (i1, i2, i3) match {
        case (_, _, index) if index == s3.length => true
        case (index, _, _) if index == s1.length =>
          var ans = true
          for (i <- i3 until s3.length if ans)
            if (s2.charAt(i - i1) != s3.charAt(i))
              ans = false
          ans
        case (_, index, _) if index == s2.length =>
          var ans = true
          for (i <- i3 until s3.length if ans)
            if (s1.charAt(i - i2) != s3.charAt(i))
              ans = false
          ans
        case _ =>
          if (s1.charAt(i1) == s3.charAt(i3) && interChar(i1 + 1, i2, i3 + 1))
            true
          else if (s2.charAt(i2) == s3.charAt(i3) && interChar(i1, i2 + 1, i3 + 1))
            true
          else
            false
      }
    }

    if (s1.length + s2.length == s3.length) {
      if (s1.nonEmpty && s2.nonEmpty && s3.nonEmpty)
        interChar(0, 0, 0)
      else
        s1 == s3 || s2 == s3
    } else false

  }
}

