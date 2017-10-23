//https://gist.github.com/bnyu/9c3281891d7e65bc157a79c5976063b7
// Accepted

import java.util.HashMap;
import java.util.Map;

/**
 * 9. Palindrome Number
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
class Solution009 {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int n = x;
        // negative number should not be palindrome
        int length = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (n != 0) {
            length++;
            map.put(length, n % 10);
            n = n / 10;
        }
        boolean ans = true;
        for (int i = 0; i < length; i++) {
            if (!map.get(i + 1).equals(map.get(length - i))) {
                ans = false;
                break;
            }
        }
        return ans;
    }
}

