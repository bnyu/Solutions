/** 120. Triangle
  * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
  * For example, given the following triangle: [[2],[3,4],[6,5,7],[4,1,8,3]]
  * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
  * Note: Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
  */
object Triangle {
  def minimumTotal(triangle: List[List[Int]]): Int = {
    val depth = triangle.length
    var initialized = false
    var min = 0

    def pathSum(level: Int, index: Int, sum: Int): Unit = {
      if (level == depth) {
        if (initialized) {
          min = if (sum < min) sum else min
        } else {
          initialized = true
          min = sum
        }
      } else {
        pathSum(level + 1, index, sum + triangle(level)(index))
        if (index + 1 < triangle(level).length)
          pathSum(level + 1, index + 1, sum + triangle(level)(index + 1))
      }
    }

    pathSum(0, 0, 0)
    min
  }
}

