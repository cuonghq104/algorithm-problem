package leetcode.medium;

import java.util.*;

public class LowestCommonAncestor {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    Queue<TreeNode> ancestorP;
    Queue<TreeNode> ancestorQ;

    int search(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return 0;

        if (root.val == p.val) {
            ancestorP.add(root);
            return 1;
        }

        if (root.val == q.val) {
            ancestorQ.add(root);
            return 2;
        }

        int resLeft = search(root.left, p, q);
        if (resLeft == 1) {
            ancestorP.add(root);
        } else if (resLeft == 2) {
            ancestorQ.add(root);
        }

        int resRight = search(root.right, p, q);
        if (resRight == 1) {
            ancestorP.add(root);
        } else if (resRight == 2) {
            ancestorQ.add(root);
        }

        return 0;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ancestorP = new LinkedList<TreeNode>();
        ancestorQ = new LinkedList<TreeNode>();
        search(root, p, q);

        Set<TreeNode> set = new HashSet<TreeNode>();
        while (!ancestorP.isEmpty()) {
            set.add(ancestorP.poll());
        }

        while(!ancestorQ.isEmpty()) {
            TreeNode top = ancestorQ.poll();
            if (set.contains(top)) {
                return top;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        TreeNode mNode1 = new TreeNode(3);
        TreeNode mNode2 = new TreeNode(5);
        TreeNode mNode3 = new TreeNode(1);
        TreeNode mNode4 = new TreeNode(6);
        TreeNode mNode5 = new TreeNode(2);
        TreeNode mNode6 = new TreeNode(0);
        TreeNode mNode7 = new TreeNode(8);
        TreeNode mNode8 = new TreeNode(7);
        TreeNode mNode9 = new TreeNode(4);

        mNode5.left = mNode8;
        mNode5.right = mNode9;

        mNode2.left = mNode4;
        mNode2.right = mNode5;

        mNode3.left = mNode6;
        mNode3.right = mNode7;

        mNode1.left = mNode2;
        mNode1.right = mNode3;

        LowestCommonAncestor mLowestCommonAncestor = new LowestCommonAncestor();
        mLowestCommonAncestor.lowestCommonAncestor(mNode1, mNode2, mNode9);
    }
}
