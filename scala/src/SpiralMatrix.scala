import scala.collection.mutable.ListBuffer

/**
  * 54. Spiral Matrix
  * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
  */
object SpiralMatrix {
  def spiralOrder(matrix: Array[Array[Int]]): List[Int] = {
    val rows = matrix.length - 1
    if (rows < 0) return Nil
    val columns = matrix(0).length - 1
    if (columns < 0) return Nil
    val ans = new ListBuffer[Int]
    var upRows = 0
    var rightCols = 0
    var downRows = 0
    var leftCols = 0
    //0123 右下左上
    var direction = if (columns == 0) 1 else 0
    var x = 0
    var y = 0
    while (upRows + downRows <= rows && rightCols + leftCols <= columns) {
      ans.append(matrix(x)(y))
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
    if (rows > 0  || columns > 0) ans.append(matrix(x)(y))
    ans.toList
  }
}

