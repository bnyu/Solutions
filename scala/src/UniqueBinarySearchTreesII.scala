import scala.collection.mutable

/** 95. Unique Binary Search Trees II
  * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
  * For example, Given n = 3, your program should return all 5 unique BST's shown below.
  */
object UniqueBinarySearchTreesII {
  def generateTrees(n: Int): List[TreeNode] = {
    var roots = mutable.MutableList[TreeNode]()
    var oldRoots = mutable.MutableList[TreeNode]()

    def generate(root: TreeNode, value: Int): Unit = {

      var preNode: TreeNode = null
      var node = root
      while (node != null) {
        if (value > node.value) {
          if (node.right == null || value < node.right.value) {
            val copiedRoot = copy(root)
            val copiedNode = search(copiedRoot, node.value)

            val tempRight0 = copiedNode.right
            val newRight0 = new TreeNode(value)
            if (preNode != null) {
              preNode.right = newRight0
              roots += copiedRoot
            } else {
              roots += newRight0
            }
            newRight0.left = copiedNode
            newRight0.right = tempRight0
            copiedNode.right = null

            val tempRight = node.right
            val newRight = new TreeNode(value)
            node.right = newRight
            newRight.right = tempRight

            node = null
          } else {
            preNode = node
            node = node.right
          }
        } else {
          if (node.left == null || value > node.left.value) {
            val copiedRoot = copy(root)
            val copiedNode = search(copiedRoot, node.value)

            val tempLeft0 = copiedNode.left
            val newLeft0 = new TreeNode(value)
            if (preNode != null) {
              preNode.left = newLeft0
              roots += copiedRoot
            } else {
              roots += newLeft0
            }
            newLeft0.right = copiedNode
            newLeft0.left = tempLeft0
            copiedNode.left = null

            val tempLeft = node.left
            val newLeft = new TreeNode(value)
            node.left = newLeft
            newLeft.left = tempLeft

            node = null
          } else {
            preNode = node
            node = node.left
          }
        }
      }
    }


    oldRoots += new TreeNode(1)
    for (i <- 2 to n) {
      for (root <- oldRoots) {
        generate(root, i)
      }
      oldRoots = oldRoots ++ roots
      roots = new mutable.MutableList[TreeNode]
    }
    oldRoots.toList
  }

  private def copy(root: TreeNode): TreeNode = {
    val copied = new TreeNode(root.value)
    if (root.left != null)
      copied.left = copy(root.left)
    if (root.right != null)
      copied.right = copy(root.right)
    copied
  }

  private def search(root: TreeNode, value: Int): TreeNode = {
    if (root == null || root.value == value)
      root
    else if (root.value < value)
      search(root.right, value)
    else
      search(root.left, value)
  }

}
