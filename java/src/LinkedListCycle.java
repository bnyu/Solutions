import java.util.HashSet;

/**
 * 141. Linked List Cycle
 * Given a linked list, determine if it has a cycle in it.
 * Follow up: Can you solve it without using extra space?
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        //so it allowed modify
        ListNode marked = new ListNode(0);
        while (head != null) {
            if (head.next == marked) {
                return true;
            }
            ListNode pre = head;
            head = head.next;
            pre.next = marked;
        }
        return false;
    }
}
