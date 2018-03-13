import scala.collection.mutable

/**
  * Definition for a binary tree node.
  * class TreeNode(var _value: Int) {
  * var value: Int = _value
  * var left: TreeNode = null
  * var right: TreeNode = null
  * }
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
