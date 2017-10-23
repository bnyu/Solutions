import scala.collection.mutable

/** 98. Validate Binary Search Tree
  * Given a binary tree, determine if it is a valid binary search tree (BST).
  * Assume a BST is defined as follows:
  * The left subtree of a node contains only nodes with keys less than the node's key.
  * The right subtree of a node contains only nodes with keys greater than the node's key.
  * Both the left and right subtrees must also be binary search trees.
  */
object ValidateBinarySearchTree {
  def isValidBST(root: TreeNode): Boolean = {
    var isValid = true
    var preValue = 0
    var gotFirst = false
    var stack = new mutable.MutableList[TreeNode]
    var node = root
    var loop = true
    while (isValid && loop) {
      if (node != null) {
        stack += node
        node = node.left
      } else if (stack.nonEmpty) {
        node = stack.last
        stack = stack.dropRight(1)
        if (gotFirst) {
          isValid = node.value > preValue
          preValue = node.value
        } else {
          gotFirst = true
          preValue = node.value
        }
        node = node.right
      } else
        loop = false
    }
    isValid
  }
}
