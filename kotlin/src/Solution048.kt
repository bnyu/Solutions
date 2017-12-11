/**
 * 48. Rotate Image
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Note:
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 */
class Solution048 {
    //顺时针
    fun rotate(matrix: Array<IntArray>): Unit {
        val size = matrix.size
        val last = size - 1
        //从最外层到中心
        for (layer in 0 until size / 2) {
            //注意减去外层layer数 旋转移动
            for (index in 0 until last - 2 * layer) {
                val upLeft = matrix[layer][layer + index]
                //upLeft 行不变,列往右
                matrix[layer][layer + index] = matrix[last - layer - index][layer]
                //downLeft 列不变,行忘上
                matrix[last - layer - index][layer] = matrix[last - layer][last - layer - index]
                //downRight 行不变,列往左
                matrix[last - layer][last - layer - index] = matrix[layer + index][last - layer]
                //upRight 列不变,行往下
                matrix[layer + index][last - layer] = upLeft
            }
        }
    }
}

