import scala.collection.mutable

/** 102. Binary Tree Level Order Traversal
  * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
  */
object BinaryTreeLevelOrderTraversal {
  def levelOrder(root: TreeNode): List[List[Int]] = {
    val list = new mutable.MutableList[List[Int]]
    val queens = new mutable.Queue[(TreeNode, Int)]
    if (root != null)
      queens.enqueue((root, 0))
    val treeLevel = new mutable.Queue[Int]
    var storeLevel = 0
    while (queens.nonEmpty) {
      val (root, level) = queens.dequeue()
      if (level > storeLevel) {
        list += treeLevel.toList
        treeLevel.clear()
        treeLevel.enqueue(root.`val`)
        storeLevel = level
      } else {
        treeLevel.enqueue(root.`val`)
      }
      if (root.left != null)
        queens.enqueue((root.left, level + 1))
      if (root.right != null)
        queens.enqueue((root.right, level + 1))
    }
    if (treeLevel.nonEmpty)
      list += treeLevel.toList
    list.toList
  }
}

