/**
 * 21. Merge Two Sorted Lists
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */
class Solution021 {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var listNode1 = l1
        var listNode2 = l2
        var previous = ListNode(0)
        val ans = previous
        var after: ListNode
        while (listNode1 != null && listNode2 != null) {
            val next: Int
            if (listNode2.`val` < listNode1.`val`) {
                next = listNode2.`val`
                listNode2 = listNode2.next
            } else {
                next = listNode1.`val`
                listNode1 = listNode1.next
            }
            after = ListNode(next)
            previous.next = after
            previous = after
        }
        previous.next = if (listNode1 == null) listNode2 else listNode1
        return ans.next
    }
}

