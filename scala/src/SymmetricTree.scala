import scala.collection.mutable

/** 101. Symmetric Tree
  * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
  * Note: Bonus points if you could solve it both recursively and iteratively.
  */
object SymmetricTree {
  def isSymmetric(root: TreeNode): Boolean = {
    if (root != null) {

      def isSymmetric_r(left: TreeNode, right: TreeNode): Boolean = {
        if (left != null && right != null) {
          left.value == right.value && isSymmetric_r(left.left, right.right) && isSymmetric_r(left.right, right.left)
        } else if (left != null || right != null)
          false
        else true
      }

      isSymmetric_r(root.left, root.right)
    }
    else true
  }

  def isSymmetric_i(root: TreeNode): Boolean = {
    if (root != null) {
      var stack = new mutable.MutableList[(TreeNode, TreeNode)]
      var isSame = true
      var loop = true
      var left = root.left
      var right = root.right
      while (isSame && loop) {
        if (left != null && right != null) {
          isSame = left.value == right.value
          if (isSame && left.left != null && right.right != null)
            stack += ((left.left, right.right))
          else if (left.left != null || right.right != null)
            isSame = false
          left = left.right
          right = right.left
        } else if (left != null || right != null) {
          isSame = false
        } else if (stack.nonEmpty) {
          val (l, r) = stack.last
          stack = stack.dropRight(1)
          left = l
          right = r
        } else
          loop = false
      }
      isSame
    } else true
  }
}

