//https://gist.github.com/bnyu/dbbd629f0bc161e5342223061bf80766
// Accepted

/**
 * 2.Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
class Solution002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = l1.val + l2.val;
        int d1 = sum % 10;
        int d2 = sum >= 10 ? 1 : 0;
        ListNode ld = new ListNode(d1);
        final ListNode ans = ld;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                sum = d2 + l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                sum = d2 + l1.val;
                l1 = l1.next;
            } else {
                sum = d2 + l2.val;
                l2 = l2.next;
            }
            d1 = sum % 10;
            d2 = sum >= 10 ? 1 : 0;
            ld.next = new ListNode(d1);
            ld = ld.next;
        }
        if (d2 == 1)
            ld.next = new ListNode(d2);
        return ans;
    }
}

