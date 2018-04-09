/**
 * 160. Intersection of Two Linked Lists
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * For example, the following two linked lists: begin to intersect at node c1.
 * -A:       a1 → a2
 * -                ↘
 * -                c1 → c2 → c3
 * -               ↗
 * -B: b1 → b2 → b3
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class IntersectionOfTwoLinkedLists {
    //O(n)time and O(1)memory
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA != null && headB != null) {
            int aLen = 1;
            int bLen = 1;
            ListNode nodeA = headA;
            ListNode nodeB = headB;
            while (nodeA.next != null) {
                aLen += 1;
                nodeA = nodeA.next;
            }
            while (nodeB.next != null) {
                bLen += 1;
                nodeB = nodeB.next;
            }
            if (nodeA == nodeB) {
                nodeA = headA;
                nodeB = headB;
                while (true) {
                    if (aLen > bLen) {
                        aLen -= 1;
                        nodeA = nodeA.next;
                    } else if (aLen < bLen) {
                        bLen -= 1;
                        nodeB = nodeB.next;
                    } else { //aligned
                        if (nodeA == nodeB) {
                            return nodeA;
                        } else {
                            nodeA = nodeA.next;
                            nodeB = nodeB.next;
                        }
                    }
                }
            }
        }
        return null;
    }
}
