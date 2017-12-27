/** 74. Search a 2D Matrix
  * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
  * Integers in each row are sorted from left to right. The first integer of each row is greater than the last integer of the previous row.
  * For example, Consider the following matrix: [[1, 3, 5, 7],[10, 11, 16, 20],[23, 30, 34, 50]], Given target = 3, return true.
  */
object SearchA2DMatrix {
  def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
    val m = if (matrix != null) matrix.length else 0
    val n = if (m > 0) matrix(0).length else 0
    var found = false
    if (n > 0) {
      var row = matrix(0)
      for (i <- 0 until m if !found) {
        if (matrix(i)(n - 1) >= target) {
          found = true
          row = matrix(i)
        }
      }
      found = false
      for (x <- row) if (x == target) found = true
    }
    found
  }
}
