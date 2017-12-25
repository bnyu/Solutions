import scala.collection.mutable

/** 62. Unique Paths
  * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
  * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
  * How many possible unique paths are there?
  */
object UniquePaths {
  def uniquePaths(m: Int, n: Int): Int = {
    val paths: mutable.HashMap[(Int, Int), Int] = mutable.HashMap()

    def upMove(m: Int, n: Int): Int = {
      if (m <= 0) 0 else if (m == 1) 1 else
        paths.getOrElseUpdate((m - 1, n), upMove(m - 1, n)) + paths.getOrElseUpdate((m, n - 1), leftMove(m, n - 1))
    }

    def leftMove(m: Int, n: Int): Int = {
      if (n <= 0) 0 else if (n == 1) 1 else
        paths.getOrElseUpdate((m - 1, n), upMove(m - 1, n)) + paths.getOrElseUpdate((m, n - 1), leftMove(m, n - 1))
    }

    if (m <= 0 || n <= 0) 0 else if (m == 1 || n == 1) 1 else leftMove(m, n - 1) + upMove(m - 1, n)
  }

}

