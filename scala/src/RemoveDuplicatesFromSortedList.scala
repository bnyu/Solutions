/** 81. Remove Duplicates from Sorted Array
  * Given a sorted linked list, delete all duplicates such that each element appear only once.
  * For example, Given 1->1->2, return 1->2. Given 1->1->2->3->3, return 1->2->3.
  */
object RemoveDuplicatesFromSortedList {
  def deleteDuplicates(head: ListNode): ListNode = {
    if (head == null)
      return null
    val preAns = new ListNode()
    var nonDupNode = preAns
    var preNode = head
    var node = head.next
    while (node != null) {
      if (node.x != preNode.x) {
        nonDupNode.next = preNode
        nonDupNode = nonDupNode.next
        preNode = node
      }
      node = node.next
    }
    nonDupNode.next = preNode
    preAns.next
  }
}
