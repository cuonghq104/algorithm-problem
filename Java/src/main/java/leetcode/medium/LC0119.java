package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 */
public class LC0119 {

    int[][] mtx;

    private int getValue(int rowIndex, int position) {
        if (position < 0 || position > rowIndex)
            return 0;

        if (rowIndex == 0)
            return 1;

        if (mtx[rowIndex][position] != 0)
            return mtx[rowIndex][position];

        int value = getValue(rowIndex - 1, position - 1) + getValue(rowIndex - 1, position);
        mtx[rowIndex][position] = value;
        return value;
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        mtx = new int[rowIndex + 1][rowIndex + 1];
        for (int i = 0; i <= rowIndex; i += 1) {
            result.add(getValue(rowIndex, i));
        }
        return result;
    }

    public void convertBinary(int num){
        int binary[] = new int[40];
        int index = 0;

        while(num > 0){
            binary[index++] = num % 2;
            num/=2;
        }
        for(int i = index-1; i >= 0; i--){
            System.out.print(binary[i]);
        }
    }

    public static void main(String[] args) {
        LC0119 mLc = new LC0119();
        mLc.convertBinary(41);
    }
}
