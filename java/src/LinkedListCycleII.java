import java.util.HashSet;

/**
 * 142. Linked List Cycle II
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * Note: Do not modify the linked list.
 * Follow up: Can you solve it without using extra space?
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode node = head;
        HashSet<ListNode> nodes = new HashSet<>();
        while (node != null) {
            if (nodes.contains(node)) {
                return node;
            }
            nodes.add(node);
            node = node.next;
        }
        return null;
    }
}
