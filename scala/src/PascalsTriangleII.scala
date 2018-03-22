/** 119. Pascal's Triangle II
  * Given an index k, return the kth row of the Pascal's triangle.
  * For example, given k = 3, Return [1,3,3,1].
  * Note: Could you optimize your algorithm to use only O(k) extra space?
  */
object PascalsTriangleII {
  def getRow(rowIndex: Int): List[Int] = {
    var row: List[Int] = Nil
    for (_ <- 0 to rowIndex) {
      var pre = 0
      row = row.map(x => {
        val elem = pre + x
        pre = x
        elem
      }) ::: 1 :: Nil
    }
    row
  }
}
