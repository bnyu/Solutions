import scala.collection.mutable

/** 85. Maximal Rectangle
  * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
  * For example, given the following matrix: 1 0 1 0 0   1 0 1 1 1   1 1 1 1 1   1 0 0 1 0  Return 6.
  */
object MaximalRectangle {
  def maximalRectangle(matrix: Array[Array[Char]]): Int = {
    val row = matrix.length
    val column = if (row > 0) matrix(0).length else 0
    if (column == 0) 0 else {
      var area = 0
      val one = '1'
      // row: (left, right, depth)
      val rows = Array.fill(row)(new mutable.MutableList[(Int, Int, Int)])

      def updateRows(r: Int, p: (Int, Int, Int)): Unit = {
        rows(r) += p
        val a = (p._2 - p._1 + 1) * p._3
        area = if (a > area) a else area
      }

      def spreadDown(r: Int, left: Int, right: Int): Unit = {
        if (r == 0) {
          updateRows(r, (left, right, 1))
        } else {
          var nonDup = true
          for (p <- rows(r - 1)) {
            if (p._1 <= right && p._2 >= left) {
              if (p._1 == left && p._2 == right) {
                updateRows(r, (p._1, p._2, p._3 + 1))
                nonDup = false
              } else if (p._1 >= left && p._2 <= right) updateRows(r, (p._1, p._2, p._3 + 1))
              else if (p._1 >= left && p._1 <= right) updateRows(r, (p._1, right, p._3 + 1))
              else if (p._2 >= left && p._2 <= right) updateRows(r, (left, p._2, p._3 + 1))
              else if (p._1 <= left && p._2 >= right) updateRows(r, (left, right, p._3 + 1))
            }
          }
          if (nonDup) updateRows(r, (left, right, 1))
        }
      }

      for (r <- 0 until row) {
        var left = -1
        var right = -1
        for (c <- 0 until column) {
          if (matrix(r)(c) == one) {
            if (left == -1)
              left = c
            right = c
            if (c == column - 1)
              spreadDown(r, left, right)
          } else if (left != -1) {
            spreadDown(r, left, right)
            left = -1
          }
        }
      }
      area
    }
  }
}
