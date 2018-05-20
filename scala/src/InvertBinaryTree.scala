/** 226. Invert Binary Tree
  * Invert a binary tree.
  */
object InvertBinaryTree {
  def invertTree(root: TreeNode): TreeNode = {
    if (root != null) {
      val l = root.left
      var r = root.right
      root.left = r
      root.right = l
      invertTree(l)
      invertTree(r)
    }
    root
  }
}
