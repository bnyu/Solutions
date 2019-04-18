/** 86. Partition List
  * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
  * You should preserve the original relative order of the nodes in each of the two partitions.
  * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
  */
object PartitionList {
  def partition(head: ListNode, x: Int): ListNode = {
    val gHead = new ListNode(0)
    val lHead = new ListNode(0)
    var gNode = gHead
    var lNode = lHead
    var node = head
    while (node != null) {
      if (node.`val` < x) {
        lNode.next = node
        lNode = node
      } else {
        gNode.next = node
        gNode = node
      }
      node = node.next
    }
    gNode.next = null
    lNode.next = gHead.next
    lHead.next
  }
}
