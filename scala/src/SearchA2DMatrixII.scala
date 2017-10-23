/** 240. Search a 2D Matrix II
  * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
  * Integers in each row are sorted in ascending from left to right.
  * Integers in each column are sorted in ascending from top to bottom.
  * Example: Consider the following matrix:
  * [
  * [1,   4,  7, 11, 15],
  * [2,   5,  8, 12, 19],
  * [3,   6,  9, 16, 22],
  * [10, 13, 14, 17, 24],
  * [18, 21, 23, 26, 30]
  * ]
  * Given target = 5, return true.  Given target = 20, return false.
  */
object SearchA2DMatrixII {
  def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
    val row = if (matrix != null) matrix.length else 0
    val column = if (row > 0) matrix(0).length else 0
    if (column > 0) {
      var top = 0
      var bottom = row - 1
      var left = 0
      var right = column - 1

      while (top <= bottom && left <= right) {
        val topLeft = matrix(top)(left)
        val topRight = matrix(top)(right)
        val bottomLeft = matrix(bottom)(left)
        val bottomRight = matrix(bottom)(right)
        if (topLeft == target || bottomRight == target) {
          return true
        } else if (topLeft > target || bottomRight < target) {
          return false
        } else {
          if (topRight == target) {
            return true
          } else if (topRight > target) {
            right -= 1 //drop right column
          } else {
            top += 1 //drop top row
          }
          if (bottomLeft == target) {
            return true
          } else if (bottomLeft > target) {
            bottom -= 1 //drop bottom row
          } else {
            left += 1 //drop left column
          }
        }
      }

      false
    } else false
  }
}

