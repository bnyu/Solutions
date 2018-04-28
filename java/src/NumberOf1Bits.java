/**
 * 191. Number of 1 Bits
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
 * Example :  Input: 11  Output: 3  Explanation: the 32-bit integer 11 has binary representation 00000000000000000000000000001011 .
 */
public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int num = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                num += 1;
            }
            n = n >>> 1;
        }
        return num;
    }
}
