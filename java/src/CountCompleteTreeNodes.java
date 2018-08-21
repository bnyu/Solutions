/**
 * 222. Count Complete Tree Nodes
 * Given a complete binary tree, count the number of nodes.
 * Note: Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 * Example:
 * Input:
 * -    1
 * -   / \
 * -  2   3
 * - / \  /
 * -4  5 6
 * Output: 6
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        int hl = 0;
        for (TreeNode node = root; node != null; node = node.left) {
            ++hl;
        }
        int hr = 0;
        for (TreeNode node = root; node != null; node = node.right) {
            ++hr;
        }
        if (hl == hr) {
            return count(hl);
        } else {
            return 1 + countNodes(root.left, hl - 1) + countNodes(root.right);
        }
    }

    private int countNodes(TreeNode root, int hl) {
        int hr = 0;
        for (TreeNode node = root; node != null; node = node.right) {
            ++hr;
        }
        if (hl == hr) {
            return count(hl);
        } else {
            return 1 + countNodes(root.left, hl - 1) + countNodes(root.right);
        }
    }

    private int count(int h) {
        int sum;
        int num = 1;
        for (int i = 0; i < h; ++i) {
            num = num << 1;
        }
        sum = num - 1;
        return sum;
    }
}

