/**
 * 25. Reverse Nodes in k-Group
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 */
class Solution025 {

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
            val after: ListNode
            if (i + 1 < tSize)
                after = tails[i + 1]
            else if (i + 1 < hSize)
                after = heads[i + 1]
            else
                break
            previous.next = after
        }
        return if (tSize > 0) tails[0] else head
    }

    private fun reverse(previous: ListNode, k: Int, i: Int): ListNode {
        var index = i
        length++
        if (index == k) {
            val next = previous.next
            if (next != null) {
                tails.add(previous)
                heads.add(next)
                reverse(next, k, 1)
            }
            return previous
        }
        val next = previous.next
        if (next != null) {
            val after = reverse(next, k, ++index)
            after.next = previous
        }
        return previous
    }

}

