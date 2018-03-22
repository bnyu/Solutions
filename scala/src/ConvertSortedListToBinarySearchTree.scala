import scala.collection.mutable

/** 109. Convert Sorted List to Binary Search Tree
  * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
  */
object ConvertSortedListToBinarySearchTree {
  def sortedListToBST(head: ListNode): TreeNode = {
    val nums = new mutable.MutableList[Int]
    var node = head
    while (node != null) {
      nums += node.x
      node = node.next
    }
    ConvertSortedArrayToBinarySearchTree.sortedArrayToBST(nums.toArray)
  }
}
