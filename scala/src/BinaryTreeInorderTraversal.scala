import scala.collection.mutable

/** 94. Binary Tree Inorder Traversal
  * Given a binary tree, return the inorder traversal of its nodes' values.
  * For example: Given binary tree [1,null,2,3], return [1,3,2].
  * Note: Recursive solution is trivial, could you do it iteratively?
  */
object BinaryTreeInorderTraversal {
  // Recursive
  def inorderTraversal(root: TreeNode): List[Int] = {
    val values = new mutable.MutableList[Int]

    def traversal(node: TreeNode): Unit = {
      if (node != null) {
        traversal(node.left)
        values += node.value
        traversal(node.right)
      }
    }

    traversal(root)
    values.toList
  }

  // Iterative
  def inorderTraversal_i(root: TreeNode): List[Int] = {
    val values = mutable.MutableList[Int]()
    // Stack is deprecated in Scala, use List instead
    var stack = mutable.MutableList[TreeNode]()
    var node = root
    var loop = true
    while (loop) {
      while (node != null) {
        stack += node
        node = node.left
      }
      if (stack.nonEmpty) {
        node = stack.last
        stack = stack.dropRight(1)
        values += node.value
        node = node.right
      } else
        loop = false
    }
    values.toList
  }

}

