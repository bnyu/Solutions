/**
 * 116. Populating Next Right Pointers in Each Node
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * Note: You may only use constant extra space. You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * For example, Given the following perfect binary tree,
 * ------1
 * ----/  \
 * ---2    3
 * --/ \  / \
 * -4  5  6  7
 * After calling your function, the tree should look like:
 * ------1 -> NULL
 * ----/  \
 * ---2 -> 3 -> NULL
 * --/ \  / \
 * -4->5->6->7 -> NULL
 */
public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        if (root != null && root.left != null) {
            link(root.left, root.right);
        }
    }

    private void link(TreeLinkNode left, TreeLinkNode right) {
        left.next = right;
        if (left.left != null) {
            link(left.left, left.right);
            link(left.right, right.left);
            link(right.left, right.right);
        }
    }
}

