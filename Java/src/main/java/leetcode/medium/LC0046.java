package leetcode.medium;

import java.util.*;

// https://leetcode.com/problems/permutations/
public class LC0046 {

    int[] values;

    void swap(int x, int y) {
        int tmp = values[x];
        values[x] = values[y];
        values[y] = tmp;
    }

    void generateNext() {
        int idx;
        for (idx = values.length - 1; idx > 0 && values[idx] < values[idx - 1]; idx -= 1) ;
        idx -= 1;

        int swapPosition = idx;
        while (swapPosition + 1 < values.length && values[swapPosition + 1] > values[idx])
            swapPosition += 1;

        swap(idx, swapPosition);
        idx += 1;

        for (int i = idx; i <= (values.length + idx - 1) / 2; i += 1) {
            swap(i, values.length + idx - 1 - i);
        }
    }

    int superDigit(int sum, int t) {
        return 0;
    }

    int exp(int sum) {
        if (sum > 9)
            return superDigit(sum, 1);
        else return sum;
    }

    boolean isStop() {
        for (int i = 0; i < values.length; i += 1) {
            if (values[i] != values.length - i) {
                return false;
            }
        }
        return true;
    }

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        values = new int[n];
        for (int i = 0; i < n; i += 1) {
            values[i] = i + 1;
        }
        List<List<Integer>> results = new ArrayList<>();

        while (!isStop()) {
            List<Integer> permu = new ArrayList<>();
            for (int val : values) {
                permu.add(nums[val - 1]);
            }
            results.add(permu);
            generateNext();
        }

        return results;
    }

    class Freq {
        Integer freq;
        int val;

        Freq(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }
    }

    int findMinimumSetLength(int[] items) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int item : items) {
            int currentFreq = freq.getOrDefault(item, 0) + 1;
            freq.put(item, currentFreq);
        }

        List<Integer> freqList = new ArrayList<>(freq.values());
        Collections.sort(freqList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        int result = 0;

        int currentAmount = 0;

        for (int idx = 0; idx < items.length && currentAmount < items.length / 2; idx += 1) {
            currentAmount += freqList.get(idx);
            result += 1;
        }

        return result;
    }

    public static void main(String[] args) {
        LC0046 mLc = new LC0046();
        int decimal = mLc.findMinimumSetLength(new int[]{1, 1, 2, 3, 2, 3});
    }
}
