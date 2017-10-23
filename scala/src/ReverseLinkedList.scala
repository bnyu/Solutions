/** 206. Reverse Linked List
  * Reverse a singly linked list.
  * Example: Input: 1->2->3->4->5->NULL  Output: 5->4->3->2->1->NULL
  * Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
  */
object ReverseLinkedList {
  def reverseList(head: ListNode): ListNode = {
    var tail: ListNode = null

    def reverse(node: ListNode): ListNode = {
      if (node.next != null)
        reverse(node.next).next = node
      else
        tail = node
      node
    }

    if (head != null)
      reverse(head).next = null
    tail
  }

  def reverseList_i(head: ListNode): ListNode = {
    if (head != null) {
      var pre = head
      var next = head.next
      while (next != null) {
        val tempNext = next.next
        next.next = pre
        pre = next
        next = tempNext
      }
      head.next = null
      pre
    } else null
  }

}
