import scala.collection.mutable

/** 124. Binary Tree Maximum Path Sum
  * Given a binary tree, find the maximum path sum.
  * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
  * For example: Given the below binary tree, Return 6.
  * -   1
  * -  / \
  * - 2   3
  */
object BinaryTreeMaximumPathSum {

  private class ThreeNode(val value: TreeNode) {
    val link: Array[ThreeNode] = Array.fill[ThreeNode](3)(null)

    def addLeft(left: ThreeNode): Unit = {
      this.link(1) = left
      left.link(0) = this
    }

    def addRight(right: ThreeNode): Unit = {
      this.link(2) = right
      right.link(0) = this
    }
  }

  def maxPathSum(root: TreeNode): Int = {
    if (root != null) {
      var singleMax = root.value
      var max = 0
      val edgeNodes = new mutable.HashSet[ThreeNode]

      def createThreeNode(root: ThreeNode, treeNode: TreeNode): Unit = {
        if (treeNode.left != null) {
          val left = new ThreeNode(treeNode.left)
          if (left.value.value > 0)
            edgeNodes.add(left)
          if (left.value.value > singleMax)
            singleMax = left.value.value
          root.addLeft(left)
          createThreeNode(left, treeNode.left)
        }
        if (treeNode.right != null) {
          val right = new ThreeNode(treeNode.right)
          if (right.value.value > 0)
            edgeNodes.add(right)
          if (right.value.value > singleMax)
            singleMax = right.value.value
          root.addRight(right)
          createThreeNode(right, treeNode.right)
        }
      }


      //是最小支撑树,只要不往回走不会重复,所以不用记录状态
      def travelThreeNode(root: ThreeNode, sum: Int, from: ThreeNode): Unit = {
        if (sum > max)
          max = sum
        for (node <- root.link if node != null && node != from)
          travelThreeNode(node, sum + node.value.value, root)
      }

      val threeRoot = new ThreeNode(root)
      if (root.value > 0)
        edgeNodes.add(threeRoot)
      createThreeNode(threeRoot, root)
      for (start <- edgeNodes)
        travelThreeNode(start, start.value.value, null)
      if (singleMax < 0) singleMax else max
    } else 0
  }
}

