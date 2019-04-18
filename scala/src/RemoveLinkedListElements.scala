/** 203. Remove Linked List Elements
  * Remove all elements from a linked list of integers that have value val.
  * Example: Input:  1->2->6->3->4->5->6, val = 6  Output: 1->2->3->4->5
  */
object RemoveLinkedListElements {
  def removeElements(head: ListNode, `val`: Int): ListNode = {
    val temp = new ListNode(0)
    temp.next = head
    var pre = temp
    var node = temp.next
    while (node != null) {
      if (node.`val` == `val`) {
        pre.next = null
      } else {
        pre.next = node
        pre = node
      }
      node = node.next
    }
    temp.next
  }
}
