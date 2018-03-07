import scala.collection.mutable

/** 96. Unique Binary Search Trees
  * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
  * For example, Given n = 3, there are a total of 5 unique BST's.
  */
object UniqueBinarySearchTrees {
  // 由95.scala可得 之前的数量加上之前每个最大节点的深度 每个产生 1 to n + 1 的新深度
  def numTrees(n: Int): Int = {
    if (n > 2) {
      var depthNum = new mutable.HashMap[Int, Int]
      var next = new mutable.HashMap[Int, Int]
      depthNum += ((1, 1))
      for (_ <- 1 until n - 1) {
        for (x <- depthNum; j <- 1 to x._1 + 1) {
          next.update(j, x._2 + next.getOrElse(j, 0))
        }
        val temp = depthNum
        depthNum = next
        next = temp
        next.clear()
      }
      val pre = depthNum.fold((0, 0))((sum, x) => (x._1 * x._2 + sum._1, x._2 + sum._2))
      pre._1 + pre._2
    }
    else n
  }
}
