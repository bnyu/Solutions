/** 105. Construct Binary Tree from Preorder and Inorder Traversal
  * Given preorder and inorder traversal of a tree, construct the binary tree.
  * Note:You may assume that duplicates do not exist in the tree.
  * For example, given
  * preorder = f c b a e d g i h j
  * inorder =  a b c d e f g h i j
  * Return the following binary tree:
  * -------f
  * -----/  \
  * ----c    g
  * ---/ \    \
  * --b   e    i
  * -/   /    / \
  * a   d    h   j
  */
object ConstructBinaryTreeFromPreorderAndInorderTraversal {
  def buildTree(preorder: Array[Int], inorder: Array[Int]): TreeNode = {
    val length = inorder.length
    if (length > 0) {
      val root = new TreeNode(preorder(0))
      val orderMap: Map[Int, Int] = (0 until length).map(i => (inorder(i), i)).toMap

      def insert(root: TreeNode, value: Int): Unit = {
        if (orderMap(root.value) < orderMap(value)) {
          if (root.right == null)
            root.right = new TreeNode(value)
          else
            insert(root.right, value)
        } else {
          if (root.left == null)
            root.left = new TreeNode(value)
          else
            insert(root.left, value)
        }
      }

      for (i <- 1 until length)
        insert(root, preorder(i))
      root
    } else null
  }
}

