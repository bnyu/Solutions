/** 200. Number of Islands
  * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
  * Example 1: Input:
  * 11110
  * 11010
  * 11000
  * 00000 Output: 1
  * Example 2: Input:
  * 11000
  * 11000
  * 00100
  * 00011 Output: 3
  */
object NumberOfIslands {
  def numIslands(grid: Array[Array[Char]]): Int = {
    val row = grid.length - 1
    val column = if (row >= 0) grid(0).length - 1 else -1
    if (row >= 0 && column >= 0) {
      def spread(i: Int, k: Int): Unit = {
        grid(i)(k) = '2'
        if (i > 0 && grid(i - 1)(k) == '1')
          spread(i - 1, k)
        if (i < row && grid(i + 1)(k) == '1')
          spread(i + 1, k)
        if (k > 0 && grid(i)(k - 1) == '1')
          spread(i, k - 1)
        if (k < column && grid(i)(k + 1) == '1')
          spread(i, k + 1)
      }

      var n = 0
      for (i <- 0 to row; k <- 0 to column if grid(i)(k) == '1') {
        spread(i, k)
        n += 1
      }
      n
    } else 0
  }
}
