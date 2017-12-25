import scala.collection.mutable

/** 64. Minimum Path Sum
  * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
  * Note: You can only move either down or right at any point in time.
  */
object MinimumPathSum {
  def minPathSum(grid: Array[Array[Int]]): Int = {
    //到这格子的最小和
    val paths: mutable.HashMap[(Int, Int), Int] = mutable.HashMap()

    def move(p: (Int, Int), sum: Int): Int = {
      if (p._1 <= 0 || p._2 <= 0) sum else if (p._1 == 1) {
        var x = sum
        for (i <- 0 until p._2) x += grid(0)(i)
        x
      } else if (p._2 == 1) {
        var x = sum
        for (i <- 0 until p._1) x += grid(i)(0)
        x
      } else {
        val leftGrid = (p._1, p._2 - 1)
        val upGrid = (p._1 - 1, p._2)
        val leftPathSum = paths.getOrElseUpdate(leftGrid, move(leftGrid, sum))
        val upPathSum = paths.getOrElseUpdate(upGrid, move(upGrid, sum))
        //这格加上到这最小路径
        Math.min(leftPathSum, upPathSum) + grid(p._1 - 1)(p._2 - 1)
      }
    }

    val m = if (grid != null) grid.length else 0
    val n = if (m > 0) grid(0).length else 0
    move((m, n), 0)
  }
}

