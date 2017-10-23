import scala.collection.mutable

/** 119. Pascal's Triangle II
  * Given an index k, return the kth row of the Pascal's triangle.
  * For example, given k = 3, Return [1,3,3,1].
  * Note: Could you optimize your algorithm to use only O(k) extra space?
  */
object PascalsTriangleII {
  def getRow(rowIndex: Int): List[Int] = {
    val row = mutable.MutableList.fill(rowIndex + 1)(1)
    var index = 1
    for (_ <- 1 until rowIndex) {
      var pre = 1
      for (i <- 1 to index) {
        val x = row(i)
        row(i) = pre + x
        pre = x
      }
      index += 1
    }
    row.toList
  }
}
