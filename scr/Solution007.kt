//https://gist.github.com/bnyu/671c9da852d5e28a196469c30cba36b1
// Accepted

/**
 * 7. Reverse Integer
 * Reverse digits of an integer.
 */
class Solution007 {
    public int reverse(int x) {
        // 0x80000000 = ~0x80000000 + 1
        if (x == Integer.MIN_VALUE)
            return 0;
        int num = x >= 0 ? x : -1 * x;
        int ans = 0;
        while (num / 10 > 0) {
            ans = ans * 10 + num % 10;
            num = num / 10;
        }
        int n = num % 10;
        if (ans > 214748364)
            return 0;
        else if (ans == 214748364)
            if ((n > 8 && x < 0) || (n > 7 && x > 0))
                return 0;
        ans = ans * 10 + n;
        ans = x >= 0 ? ans : -1 * ans;
        return ans;
    }
}

