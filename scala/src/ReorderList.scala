/** 143. Reorder List
  * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
  * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
  * You must do this in-place without altering the nodes' values.
  * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
  */
object ReorderList {
  def reorderList(head: ListNode): Unit = {
    var nodes: List[ListNode] = Nil
    var node = head
    while (node != null) {
      val pre = node
      nodes = nodes ::: pre :: Nil
      node = pre.next
      pre.next = null
    }
    var i = 0
    var j = nodes.length - 1
    var loop = i < j
    while (loop) {
      if (i < j) nodes(i).next = nodes(j) else loop = false
      i += 1
      if (i < j) nodes(j).next = nodes(i) else loop = false
      j -= 1
    }
  }
}
