package leetcode.medium;

/**
 * https://leetcode.com/problems/subrectangle-queries/
 */
public class LC1476 {
    int[][] rectangle;

    public LC1476(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i <= row2; i += 1) {
            for (int j = col1; j <= col2; j += 1) {
                rectangle[i][j] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return rectangle[row][col];
    }
}
