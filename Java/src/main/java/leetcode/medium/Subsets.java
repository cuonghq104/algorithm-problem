package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC0078
 * https://leetcode.com/problems/subsets/
 */
public class Subsets {

    List<Integer> cloneList(List<Integer> current) {
        return new ArrayList<>(current);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums.length > 0) {
            Arrays.sort(nums);
            List<Integer> maxIndex = new ArrayList<>();
            results.add(new ArrayList<>());
            maxIndex.add(-1);
            int start = 0;
            int end = 0;

            for (int k = 1; k <= nums.length; k += 1) {
                for (int i = start; i <= end; i += 1) {
                    int idx = maxIndex.get(i);
                    List<Integer> current = results.get(i);
                    for (int j = idx + 1; j < nums.length; j += 1) {
                        List<Integer> newList = cloneList(current);
                        newList.add(nums[j]);

                        results.add(newList);
                        maxIndex.add(j);
                    }
                }
                start = end + 1;
                end = results.size() - 1;
            }
        }
        return results;
    }

    public static void main(String[] args) {
        Subsets mSubsets = new Subsets();
        mSubsets.subsets(new int[] {1, 2, 3});

        System.out.println((0.3 - 0.2) == (0.2 - 0.1));
    }
}
