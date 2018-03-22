/** 106. Construct Binary Tree from Inorder and Postorder Traversal
  * Given inorder and postorder traversal of a tree, construct the binary tree.
  * Note: You may assume that duplicates do not exist in the tree.
  */
object ConstructBinaryTreeFromInorderAndPostorderTraversal {
  def buildTree(inorder: Array[Int], postorder: Array[Int]): TreeNode = {
    ConstructBinaryTreeFromPreorderAndInorderTraversal.buildTree(postorder.reverse, inorder = inorder)
  }
}
