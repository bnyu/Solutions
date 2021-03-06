/**
  * 61. Rotate List
  * Given a list, rotate the list to the right by k places, where k is non-negative.
  */
object RotateList {
  def rotateRight(head: ListNode, k: Int): ListNode = {
    //倒数次序 k前一个node 尾node
    def findNode(head: ListNode, k: Int): (Int, ListNode, ListNode) = {
      val x = if (head.next == null) (0, head, head) else findNode(head.next, k)
      //退出栈每次+1 仅在k前一个位置改变node并保持
      if (x._1 == k) (x._1 + 1, head, x._3) else (x._1 + 1, x._2, x._3)
    }

    //居然要求考虑k大于链表长度的情况...
    if (head == null) null else {
      val (len, preNode, preTail) = findNode(head, k)
      val (_, node, tail) = if (k > len) findNode(head, k % len) else (len, preNode, preTail)
      tail.next = head
      val newHead = node.next
      node.next = null
      newHead
    }
  }
}

