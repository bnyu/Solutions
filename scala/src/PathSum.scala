/** 112. Path Sum
  * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
  */
object PathSum {
  def hasPathSum(root: TreeNode, sum: Int): Boolean = {
    var has = false

    def addSum(root: TreeNode, pathSum: Int): Unit = {
      if (!has) {
        if (root.left == null && root.right == null) {
          has = pathSum == sum
        } else {
          if (root.left != null)
            addSum(root.left, pathSum + root.left.value)
          if (root.right != null)
            addSum(root.right, pathSum + root.right.value)
        }
      }
    }

    if (root != null)
      addSum(root, root.value)
    has
  }
}

