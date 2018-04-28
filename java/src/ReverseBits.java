/**
 * 190. Reverse Bits
 * Reverse bits of a given 32 bits unsigned integer.
 * Example: Input: 43261596  Output: 964176192
 * Explanation: 43261596 represented in binary as 00000010100101000001111010011100,
 * return 964176192 represented in binary as 00111001011110000010100101000000.
 * Follow up: If this function is called many times, how would you optimize it?
 */
public class ReverseBits {
    // because it will be called many times
    private static Integer[] bit = new Integer[32];

    static {
        int n = 1;
        for (int i = 0; i < bit.length; ++i) {
            bit[i] = n;
            n = n << 1;
        }
    }

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int r = 0;
        for (int i = 0; i < bit.length; ++i) {
            if ((n & bit[i]) == bit[i]) {
                r += bit[bit.length - 1 - i];
            }
        }
        return r;
    }
}

