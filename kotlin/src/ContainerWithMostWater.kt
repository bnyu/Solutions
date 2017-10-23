/**
 * 11. Container With Most Water
 * You may not slant the container and n is at least 2.
 */
class ContainerWithMostWater {
    fun maxArea(height: IntArray): Int {
        var area = 0
        val length = height.size
        //左边最高
        var lHighest = 0
        var leftIsHigher = false
        //左边边长 从左往右
        for (i in 0 until length - 1) {
            val leftH = height[i]
            //除非比左边最高更高 再往右更小
            if (leftH <= lHighest)
                continue
            //已没有更高的
            if (leftIsHigher)
                break
            //当前左边边长
            lHighest = leftH
            //右边低于左边最高
            var rHighest = 0
            //右边边长 从右往左
            for (j in length - 1 downTo i + 1) {
                leftIsHigher = true
                val side = j - i
                val rightH = height[j]
                val tempArea: Int
                //右边比左边高
                if (rightH >= leftH) {
                    tempArea = leftH * side
                    area = Math.max(area, tempArea)
                    leftIsHigher = false
                    //右边再往左 再高也更小
                    break
                } else if (rightH > rHighest) {
                    rHighest = rightH
                    tempArea = rHighest * side
                    area = Math.max(area, tempArea)
                }
            }
        }
        return area
    }
}

