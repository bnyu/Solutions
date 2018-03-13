/** 100. Same Tree
  * Given two binary trees, write a function to check if they are the same or not.
  * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
  */
object SameTree {
  def isSameTree(p: TreeNode, q: TreeNode): Boolean = {
    var isSame = true

    def traversal(p: TreeNode, q: TreeNode): Boolean = {
      if (isSame) {
        if (p != null && q != null) {
          isSame = p.value == q.value &&
            traversal(p.left, q.left) && traversal(p.right, q.right)
        } else if (p != null || q != null)
          isSame = false
      }
      isSame
    }

    traversal(p, q)
  }
}

