package p29;
//https://gist.github.com/bnyu/7d70a2f7589a6a7da3fbe782ddcd8565
// Accepted

/**
 * 29. Divide Two Integers
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 */
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0)
            return 0;
        else if (divisor == 1)
            return dividend;
        else if (divisor == -1) {
            dividend = ~dividend + 1;
            if (dividend == Integer.MIN_VALUE)
                return Integer.MAX_VALUE;
            else return dividend;
        } else if (dividend == divisor)
            return 1;
        boolean min = false;
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 2)
                return Integer.MIN_VALUE >> 1;
            if (divisor == -2)
                return ~(Integer.MIN_VALUE >> 1) + 1;
            //......
            if (divisor == 3)
                return -715827882;
            if (divisor == -3)
                return 715827882;
            //除以2以上都一样
            dividend = Integer.MAX_VALUE;
            min = true;
        }
        int quotient = 0;
        //都化成正数
        boolean divisorNegative = false;
        boolean dividendNegative = false;
        if (dividend < 0) {
            dividend = ~dividend + 1;
            dividendNegative = true;
        }
        if (divisor < 0) {
            divisor = ~divisor + 1;
            divisorNegative = true;
        }
        if (dividend < divisor)
            return 0;

        int up = 0;
        //被除数是2的幂次数
        int temp = divisor - 1;
        if ((divisor & temp) == 0) {
            while ((temp & 0b1) == 0b1) {
                temp = temp >> 1;
                up++;
            }
        }
        if (up > 0) {
            quotient = dividend >> up;
        } else {
            //依次减
            while (dividend >= 0 && divisor > 0 || dividend <= 0 && divisor < 0) {
                dividend -= divisor;
                quotient++;
            }
            quotient--;
        }
        if (dividendNegative ^ divisorNegative)
            quotient = ~quotient + 1;
        if (min)
            quotient = ~quotient + 1;
        return quotient;
    }
}

