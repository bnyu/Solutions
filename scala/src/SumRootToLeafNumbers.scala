/** 129. Sum Root to Leaf Numbers
  * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
  * An example is the root-to-leaf path 1->2->3 which represents the number 123.
  * Find the total sum of all root-to-leaf numbers.
  * For example, The root-to-leaf path 1->2 represents the number 12. The root-to-leaf path 1->3 represents the number 13. Return the sum = 12 + 13 = 25.
  * --1
  * -/ \
  * 2   3
  */
object SumRootToLeafNumbers {
  def sumNumbers(root: TreeNode): Int = {
    var total = 0

    def addNum(root: TreeNode, num: Int): Unit = {
      val n = 10 * num + root.value
      if (root.left == null && root.right == null) {
        total += n
      } else {
        if (root.left != null)
          addNum(root.left, n)
        if (root.right != null)
          addNum(root.right, n)
      }
    }

    if (root != null)
      addNum(root, 0)
    total
  }
}

