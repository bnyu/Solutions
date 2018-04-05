import scala.collection.mutable

/** 145. Binary Tree Postorder Traversal
  * Given a binary tree, return the postorder traversal of its nodes' values.
  * Note: Recursive solution is trivial, could you do it iteratively?
  */
object BinaryTreePostorderTraversal {
  def postorderTraversal(root: TreeNode): List[Int] = {
    val ans = new mutable.MutableList[Int]
    var stack = new mutable.MutableList[TreeNode]
    stack += root
    var node = root
    var preNode: TreeNode = null
    var loop = root != null
    while (loop) {
      var ahead = node != null
      while (ahead) {
        if (node.right != null) {
          stack += node.right
          if (node.left != null) {
            stack += node.left
            node = node.left
          } else {
            node = node.right
          }
        } else if (node.left != null) {
          stack += node.left
          node = node.left
        } else ahead = false
      }
      var back = true
      var record: TreeNode = null
      while (back && stack.nonEmpty) {
        loop = false
        val child = stack.last
        //不是才遍历过的节点 是之前放入的右节点(即刚记录完父节点的左节点,再遍历它右节点) 有子节点 然后再对其遍历
        if (child != preNode && child.left != record && child.right != record && (child.left != null || child.right != null)) {
          node = child
          preNode = node
          back = false
          loop = true
        } else {
          stack = stack.dropRight(1)
          ans += child.value
          record = child
        }
      }
    }
    ans.toList
  }
}

