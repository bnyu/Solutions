/** 99. Recover Binary Search Tree
  * Two elements of a binary search tree (BST) are swapped by mistake.
  * Recover the tree without changing its structure.
  * Note: A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
  */
object RecoverBinarySearchTree {
  def recoverTree(root: TreeNode): Unit = {
    //using constant space
    val mistake = Array.fill[TreeNode](2)(null)
    var found = 0

    def inorder(root: TreeNode, pre: TreeNode): TreeNode = {
      if (found == 2)
        return null
      val node = if (root.left != null)
        inorder(root.left, pre)
      else //root doesn't has a left child, root's predecessor is iterative father until that is a right child
        pre
      if (node != null && node.value >= root.value) {
        //because meet bigger firstly
        if (found == 0) {
          mistake(0) = node
          mistake(1) = root
          found = 1
        } else {
          mistake(1) = root
          found = 2
        }
      }
      //return the root's father's predecessor when root is a left child, only this situation will be used
      if (root.right != null)
        inorder(root.right, root)
      else root
    }

    inorder(root, null)
    if (found > 0) {
      val temp = mistake(0).value
      mistake(0).value = mistake(1).value
      mistake(1).value = temp
    }
  }
}
