/** 108. Convert Sorted Array to Binary Search Tree
  * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
  * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
  */
object ConvertSortedArrayToBinarySearchTree {
  def sortedArrayToBST(nums: Array[Int]): TreeNode = {
    if (nums.nonEmpty) {

      def addNode(root: TreeNode, from: Int, center: Int, to: Int): Unit = {
        if (center > from) {
          val mid = (from + center) / 2 // mid != center
          root.left = new TreeNode(nums(mid))
          addNode(root.left, from, mid, center - 1)
        }
        if (center < to) {
          val mid = (to + center + 1) / 2 // mid != center
          root.right = new TreeNode(nums(mid))
          addNode(root.right, center + 1, mid, to)
        }
      }

      val mid = nums.length / 2
      val root = new TreeNode(nums(mid))
      addNode(root, 0, mid, nums.length - 1)
      root
    } else null
  }
}

