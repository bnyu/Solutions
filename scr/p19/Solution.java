package p19;
//https://gist.github.com/bnyu/2ee872fc9a8840c2a66651639ae8774f
// Accepted

import java.util.HashMap;
import java.util.Map;

/**
 * 19. Remove Nth Node From End of List
 * Given a linked list, remove the nth node from the end of list and return its head. Given n will always be valid.
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer, ListNode> map = new HashMap<>();
        int i = 0;
        ListNode next = head;
        while (next != null) {
            i++;
            map.put(i, next);
            next = next.next;
        }
        if (n < i) {
            ListNode previous = map.get(i - n);
            previous.next = map.getOrDefault(i - n + 2, null);
        } else
            head = head.next;
        return head;
    }
}

