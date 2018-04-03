import java.util.HashMap;

/**
 * 138. Copy List with Random Pointer
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 */
public class CopyListWithRandomPointer {
    private HashMap<RandomListNode, RandomListNode> copiedPair = new HashMap<>();

    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode temp = new RandomListNode(0);
        copy(head, temp);
        addPointer();
        return temp.next;
    }

    private void copy(RandomListNode head, RandomListNode copied) {
        if (head != null) {
            copied.next = new RandomListNode(head.label);
            copiedPair.put(head, copied.next);
            copy(head.next, copied.next);
        }
    }

    private void addPointer() {
        for (HashMap.Entry<RandomListNode, RandomListNode> entry : copiedPair.entrySet()) {
            RandomListNode node = entry.getKey();
            RandomListNode copied = entry.getValue();
            RandomListNode random = node.random;
            if (random != null) {
                copied.random = copiedPair.get(random);
            }
        }
    }
}

