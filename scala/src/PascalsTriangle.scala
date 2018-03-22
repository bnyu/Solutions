/** 118. Pascal's Triangle
  * Given numRows, generate the first numRows of Pascal's triangle.
  * For example, given numRows = 5, Return [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
  */
object PascalsTriangle {
  def generate(numRows: Int): List[List[Int]] = {
    if (numRows > 0) {
      var row: List[Int] = Nil
      var ans = List[List[Int]]()
      for (_ <- 0 until numRows) {
        var pre = 0
        val nextRow = row.map(x => {
          val elem = pre + x
          pre = x
          elem
        }) ::: 1 :: Nil
        ans = ans ::: nextRow :: Nil
        row = nextRow
      }
      ans
    } else Nil
  }
}

