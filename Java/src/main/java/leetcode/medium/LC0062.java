package leetcode.medium;

public class LC0062 {

    class TreeNode {
        int row;
        int col;
        TreeNode left;
        TreeNode right;

        TreeNode(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    TreeNode mRoot;
    int mNumRow;
    int mNumCol;


    int[][] saved;

    private int traversal(TreeNode mNode) {
        if (mNode.row == mNumRow && mNode.col == mNumCol) {
            return 1;
        } else {
            int row = mNode.row;
            int col = mNode.col;

            if (saved[row][col] != 0)
                return saved[row][col];

            int bottom = 0;
            int right = 0;
            if (mNode.row < mNumRow) {
                bottom = traversal(new TreeNode(mNode.row + 1, mNode.col));
            }
            if (mNode.col < mNumCol) {
                right = traversal(new TreeNode(mNode.row, mNode.col + 1));
            }

            saved[row][col] = bottom + right;
            return bottom + right;
        }
    }

    public int uniquePaths(int m, int n) {
        saved = new int[m + 1][n + 1];
        this.mNumCol = n;
        this.mNumRow = m;
        mRoot = new TreeNode(1, 1);
        int result = traversal(mRoot);
        return result;
    }

    public static void main(String[] args) {
        LC0062 mLC = new LC0062();
        mLC.uniquePaths(23, 13);
    }


}
