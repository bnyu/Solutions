/** 92. Reverse Linked List II
  * Reverse a linked list from position m to n. Do it in-place and in one-pass.
  * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4, return 1->4->3->2->5->NULL.
  * Note: Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.
  */
object ReverseLinkedListII {
  private val temp = new ListNode(0)

  def reverseBetween(head: ListNode, m: Int, n: Int): ListNode = {
    if (m == n) head else {

      var node0: ListNode = null
      var node1: ListNode = null
      var node2: ListNode = null
      var node3: ListNode = null

      def reverse(previous: ListNode, index: Int): Unit = {
        val i = index + 1
        val next = previous.next
        if (next != null) {
          if (i < m) {
            reverse(next, i)
          } else if (i == m) {
            node0 = previous
            node1 = next
            reverse(next, i)
          } else if (i > m && i < n) {
            reverse(next, i)
            next.next = previous
          } else if (i == n) {
            node2 = next
            node3 = next.next
            next.next = previous
          }
        }
      }

      temp.next = head
      reverse(temp, 0)
      node0.next = node2
      node1.next = node3
      temp.next
    }
  }
}
