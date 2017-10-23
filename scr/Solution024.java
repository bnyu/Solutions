//https://gist.github.com/bnyu/67279475ef0473b91b57d50a32998507
// Accepted

/**
 * 24. Swap Nodes in Pairs
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
class Solution024 {
    public ListNode swapPairs(ListNode head) {
        ListNode ans;
        if (head == null)
            return null;
        else if (head.next == null)
            return head;
        else
            ans = head.next;
        ListNode previous = head;
        ListNode now = previous.next;
        ListNode after;
        boolean left = true;
        while (true) {
            after = now.next;
            now.next = previous;
            if (after != null) {
                now = after.next;
                previous.next = now;
                if (now != null)
                    previous = after;
                else break;
            } else {
                previous.next = null;
                left = false;
                break;
            }
        }
        if (left)
            previous.next = after;
        return ans;
    }
}

