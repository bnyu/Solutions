import scala.collection.mutable

/** 144. Binary Tree Preorder Traversal
  * Given a binary tree, return the preorder traversal of its nodes' values.
  * Note: Recursive solution is trivial, could you do it iteratively?
  */
object BinaryTreePreorderTraversal {
  def preorderTraversal(root: TreeNode): List[Int] = {
    var stack = new mutable.MutableList[TreeNode]
    val ans = new mutable.MutableList[Int]
    var node = root
    var loop = true
    while (loop) {
      if (node != null) {
        ans += node.value
        if (node.right != null)
          stack += node.right
        node = node.left
      } else if (stack.nonEmpty) {
        node = stack.last
        stack = stack.dropRight(1)
      } else loop = false
    }
    ans.toList
  }
}
