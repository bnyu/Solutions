import java.util.ArrayList;
import java.util.List;

/**
 * 138. Copy List with Random Pointer
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 */
public class CopyListWithRandomPointer {
    private List<RandomListNode> nodeList = new ArrayList<>();
    private List<RandomListNode> copiedList = new ArrayList<>();

    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode temp = new RandomListNode(0);
        copy(head, temp);
        addPointer();
        return temp.next;
    }

    private void copy(RandomListNode head, RandomListNode copied) {
        if (head != null) {
            copied.next = new RandomListNode(head.label);
            nodeList.add(head);
            copiedList.add(copied.next);
            copy(head.next, copied.next);
        }
    }

    private void addPointer() {
        for (int j = 0; j < nodeList.size(); j++) {
            RandomListNode node = nodeList.get(j);
            RandomListNode random = node.random;
            if (random != null) {
                RandomListNode copied = copiedList.get(j);
                int index = -1;
                for (int i = 0; i < nodeList.size(); i++) {
                    if (random == nodeList.get(i)) {
                        index = i;
                        break;
                    }
                }
                copied.random = copiedList.get(index);
            }
        }
    }
}

