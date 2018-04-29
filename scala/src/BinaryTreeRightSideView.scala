import scala.collection.mutable

/** 199. Binary Tree Right Side View
  * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
  * Example: Input: [1,2,3,null,5,null,4] Output: [1, 3, 4]
  * Explanation:
  * -    1       <---
  * -  /  \
  * - 2    3     <---
  * - \     \
  * -  5     4   <---
  */
object BinaryTreeRightSideView {
  def rightSideView(root: TreeNode): List[Int] = {
    val right = new mutable.MutableList[Int]
    val stack = new mutable.ArrayStack[(TreeNode, Int)]
    if (root != null)
      stack.push(root, 0)
    while (stack.nonEmpty) {
      var (node, depth) = stack.pop()
      do {
        if (depth == right.length)
          right += node.value
        depth += 1
        if (node.left != null)
          stack.push(node.left, depth)
        node = node.right
      } while (node != null)
    }
    right.toList
  }
}
