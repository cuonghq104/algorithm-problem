package leetcode.medium;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
public class KthSmallestElement {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int k;
    int result;

    void preorder(TreeNode root) {
        if (k > 0 && root.left != null) {
            preorder(root.left);
        }
        if (k > 0) {
            result = root.val;
            k -= 1;
        }
        if (k > 0 && root.right != null) {
            preorder(root.right);
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        this.result = 0;
        preorder(root);
        return result;
    }
}
