package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/counting-bits/
 * LC0338
 */

public class CountingBit {

    public int[] countBits(int num) {
        int[] results = new int[num];
        int[] init = new int[] {0, 1};

        for (int i = 0; i < Math.min(num, 2); i += 1) {
            results[i] = init[i];
        }

        if (num < 2) {
            return results;
        }

        int startIndex = 1;
        int endIndex = 1;

        int idx = 2;
        while (idx <= num) {

            for (int i = startIndex; i <= endIndex && idx <= num; i += 1) {
                results[idx++] = results[i];
            }

            for (int i = startIndex; i <= endIndex && idx <= num; i += 1) {
                results[idx++] = results[i] + 1;
            }

            int nextLength = 2 * (endIndex - startIndex + 1);
            startIndex = endIndex + 1;
            endIndex = endIndex + (nextLength - 1);
        }

        return results;
    }
}
