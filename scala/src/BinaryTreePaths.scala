import scala.collection.mutable

/** 257. Binary Tree Paths
  * Given a binary tree, return all root-to-leaf paths.
  * Note: A leaf is a node with no children.
  * Example: Input:
  *-   1
  *-  / \
  *- 2   3
  *- \
  *- 5
  * Output: ["1->2->5", "1->3"]
  * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
  */
object BinaryTreePaths{
  def binaryTreePaths(root: TreeNode): List[String] = {
    val ans = new mutable.MutableList[String]()
    val arrow = "->"

    def strPath(root: TreeNode, string: String): Unit = {
      if (root.left == null && root.right == null) {
        ans += string
      } else {
        val str0 = string + arrow
        if (root.left != null)
          strPath(root.left, str0 + root.left.value)
        if (root.right != null)
          strPath(root.right, str0 + root.right.value)
      }
    }

    if (root != null)
      strPath(root, root.value.toString)
    ans.toList
  }
}
