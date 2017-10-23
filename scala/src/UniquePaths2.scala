import scala.collection.mutable

/** 63. Unique Paths II
  * Follow up for "Unique Paths":
  * Now consider if some obstacles are added to the grids. How many unique paths would there be?
  * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
  */
object UniquePaths2 {
  def uniquePathsWithObstacles(obstacleGrid: Array[Array[Int]]): Int = {
    val paths: mutable.HashMap[(Int, Int), Int] = mutable.HashMap()

    def move(m: Int, n: Int): Int = {
      if (m <= 0 || n <= 0) 0 else if (m == 1 || n == 1) {
        //是否有障碍
        var emptyGrid = true
        for (i <- 0 until n if emptyGrid)
          if (obstacleGrid(0)(i) != 0) emptyGrid = false
        for (i <- 0 until m if emptyGrid)
          if (obstacleGrid(i)(0) != 0) emptyGrid = false
        if (emptyGrid) 1 else 0
      } else {
        val leftGrid = (m, n - 1)
        val upGrid = (m - 1, n)
        val leftPaths = if (obstacleGrid(leftGrid._1 - 1)(leftGrid._2 - 1) == 0) paths.getOrElseUpdate(leftGrid, move(leftGrid._1, leftGrid._2)) else 0
        val upPaths = if (obstacleGrid(upGrid._1 - 1)(upGrid._2 - 1) == 0) paths.getOrElseUpdate(upGrid, move(upGrid._1, upGrid._2)) else 0
        leftPaths + upPaths
      }
    }

    val m = if (obstacleGrid != null) obstacleGrid.length else 0
    val n = if (m > 0) obstacleGrid(0).length else 0
    //首末无障碍
    if (m > 0 && n > 0 && obstacleGrid(0)(0) == 0 && obstacleGrid(m - 1)(n - 1) == 0)
      move(m, n)
    else 0
  }
}

