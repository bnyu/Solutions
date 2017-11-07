//https://gist.github.com/bnyu/f8f9b8efe230dfa398f7507d2c6ff4ce
// Accepted

/**
 * 21. Merge Two Sorted Lists
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */
class Solution021 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode previous = new ListNode(0);
        final ListNode ans = previous;
        ListNode after;
        while (l1 != null && l2 != null) {
            int next;
            if (l2.val < l1.val) {
                next = l2.val;
                l2 = l2.next;
            } else {
                next = l1.val;
                l1 = l1.next;
            }
            after = new ListNode(next);
            previous.next = after;
            previous = after;
        }
        after = l1 == null ? l2 : l1;
        previous.next = after;
        return ans.next;
    }
}

