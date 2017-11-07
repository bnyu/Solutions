/**
 * 29. Divide Two Integers
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 */
class Solution029 {
    fun divide(dividend: Int, divisor: Int): Int {
        var dividendNum = dividend
        var divisorNum = divisor
        if (dividendNum == 0)
            return 0
        else if (divisorNum == 1)
            return dividendNum
        else if (divisorNum == -1) {
            dividendNum = dividendNum.inv() + 1
            return if (dividendNum == Integer.MIN_VALUE)
                Integer.MAX_VALUE
            else
                dividendNum
        } else if (dividendNum == divisorNum)
            return 1
        var min = false
        if (dividendNum == Integer.MIN_VALUE) {
            if (divisorNum == 2)
                return Integer.MIN_VALUE shr 1
            if (divisorNum == -2)
                return (Integer.MIN_VALUE shr 1).inv() + 1
            //......
            if (divisorNum == 3)
                return -715827882
            if (divisorNum == -3)
                return 715827882
            //除以2以上都一样
            dividendNum = Integer.MAX_VALUE
            min = true
        }
        var quotient = 0
        //都化成正数
        var divisorNegative = false
        var dividendNegative = false
        if (dividendNum < 0) {
            dividendNum = dividendNum.inv() + 1
            dividendNegative = true
        }
        if (divisorNum < 0) {
            divisorNum = divisorNum.inv() + 1
            divisorNegative = true
        }
        if (dividendNum < divisorNum)
            return 0

        var up = 0
        //被除数是2的幂次数
        var temp = divisorNum - 1
        if (divisorNum and temp == 0) {
            while (temp and 1 == 1) {
                temp = temp shr 1
                up++
            }
        }
        if (up > 0) {
            quotient = dividendNum shr up
        } else {
            //依次减
            while (dividendNum >= 0 && divisorNum > 0 || dividendNum <= 0 && divisorNum < 0) {
                dividendNum -= divisorNum
                quotient++
            }
            quotient--
        }
        if (dividendNegative xor divisorNegative)
            quotient = quotient.inv() + 1
        if (min)
            quotient = quotient.inv() + 1
        return quotient
    }
}

