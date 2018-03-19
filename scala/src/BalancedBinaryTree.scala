/** 110. Balanced Binary Tree
  * Given a binary tree, determine if it is height-balanced.
  * For this problem, a height-balanced binary tree is defined as:
  * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
  */
object BalancedBinaryTree {
  def isBalanced(root: TreeNode): Boolean = {
    var balanced = true

    def detect(root: TreeNode): Int = {
      if (!balanced || root == null) {
        0
      } else {
        val leftDepth = detect(root.left) + 1
        val rightDepth = detect(root.right) + 1
        val depth = if (leftDepth >= rightDepth) (leftDepth, rightDepth) else (rightDepth, leftDepth)
        if (depth._1 - depth._2 > 1) balanced = false
        depth._1
      }
    }

    detect(root)
    balanced
  }
}

