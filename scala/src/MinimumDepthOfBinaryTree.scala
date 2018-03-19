/** 111. Minimum Depth of Binary Tree
  * Given a binary tree, find its minimum depth.
  * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
  */
object MinimumDepthOfBinaryTree {
  def minDepth(root: TreeNode): Int = {
    var min = -1

    def detect(root: TreeNode, depth: Int): Unit = {
      if (min < 0 || depth < min) {
        if (root.left == null && root.right == null) {
          min = depth //leaf node means no child node
        } else {
          if (root.left != null)
            detect(root.left, depth + 1)
          if (root.right != null)
            detect(root.right, depth + 1)
        }
      }
    }

    if (root != null) {
      detect(root, 1)
      min
    } else 0
  }
}

