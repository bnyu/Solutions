/** 107. Binary Tree Level Order Traversal II
  * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
  */
object BinaryTreeLevelOrderTraversal2 {
  def levelOrderBottom(root: TreeNode): List[List[Int]] = {
    BinaryTreeLevelOrderTraversal.levelOrder(root).reverse
  }
}
