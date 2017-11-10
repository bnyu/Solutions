/**
 * 42. Trapping Rain Water
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
class Solution042 {
    fun trap(height: IntArray): Int {
        return if (height.size < 3) 0 else {
            var ans = 0
            var left = height[0]
            var water = 0
            var leftIndex = 0
            for (i in 1 until height.size) {
                val bottom = height[i]
                //假设右边总有比左边高的 左边围起来的水
                if (bottom < left)
                    water += left - bottom
                else {
                    //找到右边比左边高的 把这部分水算进去
                    ans += water
                    water = 0
                    //新的左边
                    left = bottom
                    leftIndex = i
                }
            }
            //最后一部分
            if (water > 0) {
                water = 0
                //反过来 同样的方法 左边一定存在比右边高的了
                var right = height[height.size - 1]
                for (i in height.size - 2 downTo leftIndex) {
                    val bottom = height[i]
                    if (bottom < right)
                        water += right - bottom
                    else {
                        ans += water
                        water = 0
                        right = bottom
                    }
                }
            }
            ans
        }
    }
}

