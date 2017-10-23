/** 125. Valid Palindrome
  * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
  * For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car" is not a palindrome.
  * Note: Have you consider that the string might be empty? This is a good question to ask during an interview. For the purpose of this problem, we define empty string as valid palindrome.
  */
object ValidPalindrome {
  def isPalindrome(s: String): Boolean = {
    var valid = true
    val str = s.filter(_.isLetterOrDigit).toLowerCase
    if (str.nonEmpty) {
      var i = 0
      var j = str.length - 1
      while (valid && i < j) {
        if (str(i) != str(j))
          valid = false
        i += 1
        j -= 1
      }
    }
    valid
  }
}
