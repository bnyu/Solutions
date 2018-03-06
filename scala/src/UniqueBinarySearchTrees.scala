/** 96. Unique Binary Search Trees
  * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
  * For example, Given n = 3, there are a total of 5 unique BST's.
  */
object UniqueBinarySearchTrees {
  // 由95.scala可得 之前的数量加上之前每个最大节点的深度 每个产生 1 to n + 1 的新深度
  def numTrees(n: Int): Int = {
    if (n > 1) {
      var depthList = List(1)
      for (_ <- 2 until n)
        depthList = depthList.flatMap(x => 1 to x + 1)
      depthList.size + depthList.sum
    } else n
  }
}
