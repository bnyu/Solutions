/** 74. Search a 2D Matrix
  * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
  * Integers in each row are sorted from left to right. The first integer of each row is greater than the last integer of the previous row.
  * For example, Consider the following matrix: [[1, 3, 5, 7],[10, 11, 16, 20],[23, 30, 34, 50]], Given target = 3, return true.
  */
object SearchA2DMatrix {
  def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
    val m = if (matrix != null) matrix.length else 0
    val n = if (m > 0) matrix(0).length else 0
    if (n > 0) {
      var i0 = 0
      var i1 = m - 1
      while (i1 - i0 > 1) {
        val i = (i0 + i1) / 2
        if (matrix(i)(0) > target) i1 = i else i0 = i
      }
      val row = if (matrix(i1)(0) > target) i0 else i1
      i0 = 0
      i1 = n - 1
      while (i1 - i0 > 1) {
        val i = (i0 + i1) / 2
        if (matrix(row)(i) > target) i1 = i else i0 = i
      }
      matrix(row)(i0) == target || matrix(row)(i1) == target
    } else false
  }
}
