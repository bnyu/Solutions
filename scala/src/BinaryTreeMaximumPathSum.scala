/** 124. Binary Tree Maximum Path Sum
  * Given a binary tree, find the maximum path sum.
  * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
  * For example: Given the below binary tree, Return 6.
  * -   1
  * -  / \
  * - 2   3
  */
object BinaryTreeMaximumPathSum {
  def maxPathSum(root: TreeNode): Int = {
    if (root != null) {
      var singleMax = root.`val`
      var totalMax = 0

      def pathSum(root: TreeNode): Int = {
        if (root != null) {
          if (root.`val` > singleMax) singleMax = root.`val` //要求至少连接一个节点 但每个节点最大路径都抛弃了负值(避免全部节点为负)
          val left = pathSum(root.left)
          val right = pathSum(root.right)
          if (left > 0 && right > 0) {
            val total = left + root.`val` + right
            if (total > totalMax)
              totalMax = total
          } //转折节点 因为是二叉树 所以只能在一个节点转折(向上再到向下) 因此不需要像之前那样转化成图
          val max = root.`val` + {
            if (left > 0 || right > 0) if (left > right) left else right else 0
          } //每个节点最大路径等于它较大的子节点最大路径+节点值 以此类推
          if (max > 0) { //若某节点最大为负 则停止往下加 即不返回负值
            if (max > totalMax) totalMax = max
            max
          } else 0
        } else 0
      }

      pathSum(root)
      if (singleMax <= 0) singleMax else totalMax
    } else 0
  }
}

