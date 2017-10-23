/**
  * 59. Spiral Matrix II
  * Given an integer n, generate a square matrix filled with elements from 1 to n*n in spiral order.
  */
object SpiralMatrix2 {
  def generateMatrix(n: Int): Array[Array[Int]] = {
    val rows = n - 1
    val columns = n - 1
    var upRows = 0
    var rightCols = 0
    var downRows = 0
    var leftCols = 0
    //0123 右下左上
    var direction = 0
    var x = 0
    var y = 0

    var i = 0
    def inc(): Int = {
      i += 1
      i
    }

    if (n <= 0) Array.empty[Array[Int]] else {
      val matrix = Array.fill[Array[Int]](n)(Array.fill[Int](n)(0))
      while (upRows + downRows <= rows && rightCols + leftCols <= columns) {
        matrix(x)(y) = inc()
        direction match {
          case 0 => y += 1
            if (y >= columns - rightCols) {
              upRows += 1
              direction = 1
            }
          case 1 => x += 1
            if (x >= rows - downRows) {
              rightCols += 1
              direction = 2
            }
          case 2 => y -= 1
            if (y <= leftCols) {
              downRows += 1
              direction = 3
            }
          case 3 => x -= 1
            if (x <= upRows) {
              leftCols += 1
              direction = 0
            }
        }
      }
      if (n > 1) matrix(x)(y) = inc()
      matrix
    }
  }
}

