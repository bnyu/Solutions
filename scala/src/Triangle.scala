import scala.collection.mutable

/** 120. Triangle
  * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
  * For example, given the following triangle: [[2],[3,4],[6,5,7],[4,1,8,3]]
  * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
  * Note: Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
  */
object Triangle {
  def minimumTotal(triangle: List[List[Int]]): Int = {
    val depth = triangle.length
    var min: Option[Int] = None
    val cache = new mutable.HashMap[(Int, Int), Int]()

    def continue(level: Int, index: Int, sum: Int): Boolean = {
      cache.get((level, index)) match {
        case None =>
          cache.put((level, index), sum)
          true
        case Some(s) if sum < s =>
          cache.put((level, index), sum)
          true
        case _ => false
      }
    }

    def pathSum(level: Int, index: Int, sum: Int): Unit = {
      if (level == depth) {
        min match {
          case None => min = Some(sum)
          case Some(s) if s > sum => min = Some(sum)
          case _ => Unit
        }
      } else {
        val sum2 = sum + triangle(level)(index)
        if (continue(level, index, sum2))
          pathSum(level + 1, index, sum2)
        if (triangle(level).lengthCompare(index + 1) > 0) {
          val sum3 = sum + triangle(level)(index + 1)
          if (continue(level, index + 1, sum3))
            pathSum(level + 1, index + 1, sum3)
        }
      }
    }

    pathSum(0, 0, 0)
    min.getOrElse(0)
  }
}

