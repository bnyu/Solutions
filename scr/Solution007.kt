/**
 * 7. Reverse Integer
 * Reverse digits of an integer.
 */
class Solution007 {
    fun reverse(x: Int): Int {
        // 0x80000000 = ~0x80000000 + 1
        if (x == Integer.MIN_VALUE)
            return 0
        var num = if (x >= 0) x else -1 * x
        var ans = 0
        //reverse
        while (num / 10 > 0) {
            ans = ans * 10 + num % 10
            num /= 10
        }
        //last digit
        val n = num % 10
        if (ans > 214748364)
            return 0
        else if (ans == 214748364)
            if (n > 8 && x < 0 || n > 7 && x > 0)
                return 0
        ans = ans * 10 + n
        ans = if (x >= 0) ans else -1 * ans
        return ans
    }
}

