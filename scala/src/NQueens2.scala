/**
  * 52. N-Queens II
  * Follow up for N-Queens problem.
  * Now, instead outputting board configurations, return the total number of distinct solutions.
  */
object NQueens2 {
  // same as NQueen
  def totalNQueens(n: Int): Int = {
    addQueen(n, 0, Set.empty, Set.empty, Set.empty)
  }


  private def addQueen(n: Int, row: Int, columnSet: Set[Int], slashSet: Set[Int], backSlashSet: Set[Int]): Int = {
    if (row >= n) {
      1
    } else {
      var validNum = 0
      for (column <- 0 until n) {
        val slash = row - column
        val backSlash = row + column
        if (!(columnSet.contains(column) || slashSet.contains(slash) || backSlashSet.contains(backSlash))) {
          validNum += addQueen(n, row + 1, columnSet + column, slashSet + slash, backSlashSet + backSlash)
        }
      }
      validNum
    }
  }
}

