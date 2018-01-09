/** 82. Remove Duplicates from Sorted List II
  * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
  * For example, Given 1->2->3->3->4->4->5, return 1->2->5. Given 1->1->1->2->3, return 2->3.
  */
object RemoveDuplicatesFromSortedListII {
  def deleteDuplicates(head: ListNode): ListNode = {
    if (head == null)
      return null
    val preAns = new ListNode()
    var nonDupNode = preAns
    var nonDup = true
    var preNode = head
    var node = head.next
    while (node != null) {
      if (node.x != preNode.x) {
        if (nonDup) {
          nonDupNode.next = preNode
          nonDupNode = nonDupNode.next
        } else
          nonDup = true
        preNode = node
      } else
        nonDup = false
      node = node.next
    }
    if (nonDup)
      nonDupNode.next = preNode //preNode.next = node = null
    else
      nonDupNode.next = null
    preAns.next
  }
}

