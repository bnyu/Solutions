/** 104. Maximum Depth of Binary Tree
  * Given a binary tree, find its maximum depth.
  * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
  * For example: Given binary tree [3,9,20,null,null,15,7], return its depth = 3.
  */
object MaximumDepthOfBinaryTree {
  def maxDepth(root: TreeNode): Int = {
    var ans = 0

    def travel(root: TreeNode, depth: Int): Unit = {
      var tail = true
      if (root.left != null) {
        tail = false
        travel(root.left, depth + 1)
      }
      if (root.right != null) {
        tail = false
        travel(root.right, depth + 1)
      }
      if (tail)
        ans = if (depth > ans) depth else ans
    }

    if (root != null)
      travel(root, 1)
    ans
  }
}

