import scala.collection.mutable

/** 114. Flatten Binary Tree to Linked List
  * Given a binary tree, flatten it to a linked list in-place.
  */
object FlattenBinaryTreeToLinkedList {
  def flatten(root: TreeNode): Unit = {
    val list = new mutable.MutableList[TreeNode]

    def preOrder(root: TreeNode): Unit = {
      list += root
      if (root.left != null)
        preOrder(root.left)
      if (root.right != null)
        preOrder(root.right)
    }

    if (root != null) {
      preOrder(root)
      if (list.tail.nonEmpty)
        list.tail.foldLeft(root)((pre, next) => {
          pre.left = null
          pre.right = next
          next
        })
    }
  }
}

