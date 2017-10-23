package p25;
//https://gist.github.com/bnyu/70b5b4b8935c41fee36ad02d66ce5feb
// Accepted

import java.util.ArrayList;
import java.util.List;

/**
 * 25. Reverse Nodes in k-Group
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 */
class Solution {

    private List<ListNode> heads = new ArrayList<>();
    private List<ListNode> tails = new ArrayList<>();
    private int length = 0;

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;
        heads.add(head);
        reverse(head, k, 1);
        int hSize = heads.size();
        int tSize = tails.size();
        if (k > length)
            return head;
        for (int i = 0; i < hSize; i++) {
            ListNode previous = heads.get(i);
            if (previous == null)
                break;
            ListNode after;
            if (i + 1 < tSize)
                after = tails.get(i + 1);
            else if (i + 1 < hSize)
                after = heads.get(i + 1);
            else break;
            previous.next = after;
        }
        return tSize > 0 ? tails.get(0) : head;
    }

    private ListNode reverse(final ListNode previous, final int k, int i) {
        if (previous != null) {
            length++;
            if (i == k) {
                final ListNode next = previous.next;
                tails.add(previous);
                heads.add(next);
                reverse(next, k, 1);
                return previous;
            }
            final ListNode after = reverse(previous.next, k, ++i);
            if (after != null) {
                after.next = previous;
                return previous;
            } else return null;
        } else return null;
    }

}

