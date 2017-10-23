import scala.collection.mutable

/**
  * 51. N-Queens
  * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
  */
object NQueens {
  def solveNQueens(n: Int): List[List[String]] = {
    if (n > 0)
      addQueen(n, 0, Set.empty[Int], Set.empty[Int], Set.empty[Int], Nil, new mutable.ListBuffer[List[String]])
    else Nil
  }

  private def addQueen(n: Int, row: Int, columnSet: Set[Int], slashSet: Set[Int], backSlashSet: Set[Int], colIndex: List[Int], ans: mutable.ListBuffer[List[String]]): List[List[String]] = {
    if (row >= n) {
      val s: List[String] = colIndex.map { i =>
        val str = List.fill(i)('.') ++ List('Q') ++ List.fill(n - 1 - i)('.')
        ("" /: str) (_ + _)
      }
      ans.append(s)
    } else {
      for (column <- 0 until n) {
        val slash = row - column
        val backSlash = row + column
        if (!(columnSet.contains(column) || slashSet.contains(slash) || backSlashSet.contains(backSlash))) {
          addQueen(n, row + 1, columnSet + column, slashSet + slash, backSlashSet + backSlash, colIndex ++ List(column), ans)
        }
      }
    }
    ans.toList
  }
}
