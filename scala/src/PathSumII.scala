import scala.collection.mutable

/** 113. Path Sum II
  * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
  */
object PathSumII {
  def pathSum(root: TreeNode, sum: Int): List[List[Int]] = {
    var allPath = new mutable.MutableList[List[Int]]

    def addSum(root: TreeNode, pathSum: Int, path: List[Int]): Unit = {
      if (root.left == null && root.right == null) {
        if (pathSum == sum)
          allPath += path
      } else {
        if (root.left != null)
          addSum(root.left, pathSum + root.left.`val`, path ::: root.left.`val` :: Nil)
        if (root.right != null)
          addSum(root.right, pathSum + root.right.`val`, path ::: root.right.`val` :: Nil)
      }
    }

    if (root != null)
      addSum(root, root.`val`, root.`val` :: Nil)
    allPath.toList
  }
}

