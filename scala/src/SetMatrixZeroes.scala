import scala.collection.mutable

/** 73. Set Matrix Zeroes
  * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
  */
object SetMatrixZeroes {
  def setZeroes(matrix: Array[Array[Int]]): Unit = {
    val m = if (matrix != null) matrix.length else 0
    val n = if (m > 0) matrix(0).length else 0
    if (n > 0) {
      val rows = mutable.HashSet[Int]()
      val columns = mutable.HashSet[Int]()
      for {i <- 0 until m; j <- 0 until n if matrix(i)(j) == 0} {
        // +=函数即add, 并没有修改val指向对象, 不等同于rows = rows + i (scala没有++操作符, +=也只是普通函数)
        rows += i
        columns += j
      }

      for {row <- rows; i <- 0 until n}
        matrix(row)(i) = 0
      for {i <- 0 until m; column <- columns}
        matrix(i)(column) = 0
    }
  }
}
