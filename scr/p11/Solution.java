package p11;
//https://gist.github.com/bnyu/37530102b32e68d31230708d64216d47
// Accepted

/**
 * 11. Container With Most Water
 * You may not slant the container and n is at least 2.
 */
class Solution {
    public int maxArea(int[] height) {
        int area = 0;
        int length = height.length;
        int lHighest = 0;
        boolean leftIsHigher = false;
        for (int i = 0; i < length - 1; i++) {
            int leftH = height[i];
            if (leftH <= lHighest)
                continue;
            if (leftIsHigher)
                break;
            lHighest = leftH;
            int rHighest = 0;
            for (int j = length - 1; j > i; j--) {
                leftIsHigher = true;
                int side = j - i;
                int rightH = height[j];
                int tempArea;
                if (rightH >= leftH) {
                    tempArea = leftH * side;
                    area = Math.max(area, tempArea);
                    leftIsHigher = false;
                    break;
                } else if (rightH > rHighest) {
                    rHighest = rightH;
                    tempArea = rHighest * side;
                    area = Math.max(area, tempArea);
                }
            }
        }
        return area;
    }
}

