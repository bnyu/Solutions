/**
 * 24. Swap Nodes in Pairs
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
internal class Solution024 {
    fun swapPairs(head: ListNode?): ListNode? {
        val ans: ListNode?
        if (head == null)
            return null
        else if (head.next == null)
            return head
        else
            ans = head.next
        var previous: ListNode = head
        var now = previous.next
        var after: ListNode?
        var left = true
        while (true) {
            after = now!!.next
            now.next = previous
            if (after != null) {
                now = after.next
                previous.next = now
                if (now != null)
                    previous = after
                else
                    break
            } else {
                previous.next = null
                left = false
                break
            }
        }
        if (left)
            previous.next = after
        return ans
    }
}

