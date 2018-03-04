/**
 * 25. Reverse Nodes in k-Group
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 */
class ReverseNodesInKGroup {

    private val heads = ArrayList<ListNode>()
    private val tails = ArrayList<ListNode>()
    private var length = 0

    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if (head == null)
            return null
        heads.add(head)
        reverse(head, k, 1)
        val hSize = heads.size
        val tSize = tails.size
        if (k > length)
            return head
        for (i in 0 until hSize) {
            val previous = heads[i]
            val after = if (i + 1 < tSize)
                tails[i + 1]
            else if (i + 1 < hSize)
                heads[i + 1]
            else
                break
            previous.next = after
        }
        return if (tSize > 0) tails[0] else head
    }

    private fun reverse(previous: ListNode, k: Int, i: Int) {
        length++
        val next = previous.next
        if (next != null) {
            if (i == k) {
                tails.add(previous)
                heads.add(next)
                reverse(next, k, 1)
            } else {
                reverse(next, k, i + 1)
                next.next = previous
            }
        }
    }

}

