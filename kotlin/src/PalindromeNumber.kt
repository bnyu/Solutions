/**
 * 9. Palindrome Number
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
class PalindromeNumber {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0)
            return false
        var n = x
        // negative number should not be palindrome
        var length = 0
        val map = HashMap<Int, Int>()
        while (n != 0) {
            length++
            map.put(length, n % 10)
            n /= 10
        }
        var ans = true
        for (i in 0 until length) {
            if (map[i + 1] != map[length - i]) {
                ans = false
                break
            }
        }
        return ans
    }
}

