import java.util.HashMap;

/**
 * 117. Populating Next Right Pointers in Each Node II
 * Given a binary tree
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * ------1
 * ----/  \
 * ---2    3
 * --/ \   \
 * -4  5    6
 * After calling your function, the tree should look like:
 * ------1 -> NULL
 * ----/  \
 * ---2 -> 3 -> NULL
 * --/ \    \
 * -4->5 --> 6 -> NULL
 * Note:
 * You may only use constant extra space.
 * Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 */
public class PopulatingNextRightPointersInEachNodeII {
    private final HashMap<Integer, TreeLinkNode> nodeMap = new HashMap<>();

    // Definition for a Node as TreeLinkNode.
    public TreeLinkNode connect(TreeLinkNode root) {
        if (root != null) {
            link(root, 0);
        }
        return root;
    }

    private void link(TreeLinkNode root, int depth) {
        root.next = nodeMap.get(depth);
        if (root.right != null) {
            link(root.right, depth + 1);
        }
        if (root.left != null) {
            link(root.left, depth + 1);
        }
        nodeMap.put(depth, root);
    }
}

