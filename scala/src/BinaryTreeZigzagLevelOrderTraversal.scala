import scala.collection.mutable

/** 103. Binary Tree Zigzag Level Order Traversal
  * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
  */
object BinaryTreeZigzagLevelOrderTraversal {
  def zigzagLevelOrder(root: TreeNode): List[List[Int]] = {
    val list = new mutable.MutableList[List[Int]]
    val queens = new mutable.Queue[(TreeNode, Int)]
    if (root != null)
      queens.enqueue((root, 0))
    var treeLevel = new mutable.Queue[Int]
    var storeLevel = 0
    while (queens.nonEmpty) {
      val (root, level) = queens.dequeue()
      if (level > storeLevel) {
        val zigzag = if (level % 2 == 1) treeLevel.toList else treeLevel.toList.reverse
        list += zigzag
        treeLevel = new mutable.Queue[Int]
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
    if (treeLevel.nonEmpty) {
      val zigzag = if (storeLevel % 2 == 0) treeLevel.toList else treeLevel.toList.reverse
      list += zigzag
    }
    list.toList
  }
}

