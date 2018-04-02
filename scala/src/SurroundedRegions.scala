/** 130. Surrounded Regions
  * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
  * A region is captured by flipping all 'O's into 'X's in that surrounded region.
  * For example,
  * X X X X
  * X O O X
  * X X O X
  * X O X X
  * After running your function, the board should be:
  * X X X X
  * X X X X
  * X X X X
  * X O X X
  */
object SurroundedRegions {
  def solve(board: Array[Array[Char]]): Unit = {
    val row = board.length - 1
    if (row > 0) {
      val column = board(0).length - 1
      if (column > 0) {

        def spread(i: Int, j: Int): Unit = {
          if (i >= 0 && i <= row && j >= 0 && j <= column) {
            if (board(i)(j) == 'O') {
              board(i)(j) = 'B'
              spread(i - 1, j)
              spread(i + 1, j)
              spread(i, j - 1)
              spread(i, j + 1)
            }
          }
        }

        for (i <- 0 to row) {
          if (board(i)(0) == 'O')
            spread(i, 0)
          if (board(i)(column) == 'O')
            spread(i, column)
        }
        for (j <- 0 to column) {
          if (board(0)(j) == 'O')
            spread(0, j)
          if (board(row)(j) == 'O')
            spread(row, j)
        }
        for (i <- 0 to row; j <- 0 to column) {
          if (board(i)(j) == 'B')
            board(i)(j) = 'O'
          else if (board(i)(j) == 'O')
            board(i)(j) = 'X'
        }
      }
    }
  }
}

