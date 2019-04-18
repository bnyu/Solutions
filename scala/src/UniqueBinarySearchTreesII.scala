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
      var node = root
      while (node != null) {
        if (node.right == null) {
          var loop = true
          var theNode = node
          while (loop) {
            val copiedRoot = copy(root)
            val route = search(copiedRoot, theNode.`val`, Nil)
            val copiedNode = route.head

            val newBiggest = new TreeNode(value)
            val preNode = route.tail
            if (preNode.nonEmpty) {
              preNode.head.right = newBiggest
              roots += copiedRoot
              theNode = preNode.head
            } else {
              roots += newBiggest
              loop = false
            }
            newBiggest.left = copiedNode
          }

          val biggest = new TreeNode(value)
          node.right = biggest
          roots += root
          node = null
        } else {
          node = node.right
        }
      }
    }

    if (n > 0) {
      oldRoots += new TreeNode(1)
      for (i <- 2 to n) {
        for (root <- oldRoots) {
          generate(root, i)
        }
        val temp = oldRoots
        oldRoots = roots
        roots = temp
        temp.clear()
      }
      oldRoots.toList
    } else Nil
  }

  private def copy(root: TreeNode): TreeNode = {
    val copied = new TreeNode(root.`val`)
    if (root.left != null)
      copied.left = copy(root.left)
    if (root.right != null)
      copied.right = copy(root.right)
    copied
  }

  private def search(root: TreeNode, value: Int, route: List[TreeNode]): List[TreeNode] = {
    if (root.`val` == value)
      root :: route
    else if (root.`val` < value)
      search(root.right, value, root :: route)
    else
      search(root.left, value, root :: route)
  }

}
