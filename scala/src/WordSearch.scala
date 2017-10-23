/** 79. Word Search
  * Given a 2D board and a word, find if the word exists in the grid.
  * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
  * For example, Given board = [ ['A','B','C','E'],['S','F','C','S'],['A','D','E','E'] ] word = "ABCCED", -> returns true, word = "SEE", -> returns true, word = "ABCB", -> returns false.
  */
object WordSearch {
  def exist(board: Array[Array[Char]], word: String): Boolean = {
    val row = board.length
    val column = if (row != 0) board.head.length else 0
    if (column == 0) word.isEmpty else {
      val roads = Array.fill(row)(Array.fill(column)(false))

      def move(i: Int, j: Int, step: Int): Boolean = {
        if (step == word.length - 1) true else {
          roads(i)(j) = true
          val nextStep = step + 1
          for (direct <- 1 to 4) {
            val (nextI, nextJ) = direct match {
              case 1 => (i - 1, j)
              case 2 => (i + 1, j)
              case 3 => (i, j - 1)
              case 4 => (i, j + 1)
            }
            if (nextI >= 0 && nextI < row && nextJ >= 0 && nextJ < column && board(nextI)(nextJ) == word.charAt(nextStep) && !roads(nextI)(nextJ)) {
              if (move(nextI, nextJ, nextStep))
                return true
            }
          }
          roads(i)(j) = false
          false
        }
      }

      for (i <- board.indices; j <- board.head.indices if board(i)(j) == word.head) {
        if (move(i, j, 0))
          return true
      }
      false
    }
  }
}

