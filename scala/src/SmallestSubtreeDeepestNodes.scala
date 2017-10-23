/** 866. Smallest Subtree with all the Deepest Nodes
  * Given a binary tree rooted at root, the depth of each node is the shortest distance to the root.
  * A node is deepest if it has the largest depth possible among any node in the entire tree.
  * The subtree of a node is that node, plus the set of all descendants of that node.
  * Return the node with the largest depth such that it contains all the deepest nodes in it's subtree.
  */
object SmallestSubtreeDeepestNodes {
  def subtreeWithAllDeepest(root: TreeNode): TreeNode = {
    var subtree: TreeNode = null
    var deepest = -1

    def getDepth(root: TreeNode, depth: Int): Int = {
      val leftDep = if (root.left != null) getDepth(root.left, depth + 1) else depth
      val rightDep = if (root.right != null) getDepth(root.right, depth + 1) else depth
      if (leftDep == rightDep && leftDep >= deepest) {
        deepest = leftDep
        subtree = root
      }
      if (leftDep >= rightDep) leftDep else rightDep
    }

    if (root != null)
      getDepth(root, 0)
    subtree
  }
}
