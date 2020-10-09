package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    List<List<Integer>> results;
    int[] candidates;
    int[] currentCombination;

    void appendResult(int length) {
        List<Integer> combination = new ArrayList<>();
        for (int i = 0; i <= length; i += 1) {
            combination.add(currentCombination[i]);
        }
        results.add(combination);
    }

    void tryAddElement(int remain, int largestIndex, int currentCombinationlength) {
        while (largestIndex >= 0 && candidates[largestIndex] > remain)
            largestIndex -= 1;
        for (int i = largestIndex; i >= 0; i -= 1) {
            currentCombination[currentCombinationlength] = candidates[i];
            if (remain - candidates[i] == 0) {
                appendResult(currentCombinationlength);
            } else {
                tryAddElement(remain - candidates[i], i, currentCombinationlength + 1);
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        results = new ArrayList<>();
        this.candidates = candidates;
        currentCombination = new int[this.candidates.length];

        Arrays.sort(this.candidates);
        tryAddElement(target, candidates.length - 1, 0);
        return results;
    }

    public static void main(String[] args) {
        CombinationSum mSum = new CombinationSum();
        mSum.findKthLargest(new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
    }

    // heap
    int[] items;
    int size;

    void swap(int i, int j) {
        int t = items[i]; items[i] = items[j]; items[j] = t;
    }

    void siftUp(int position) {
        if (position != 0) {
            int parentIndex = (position - 1) / 2;
            if (items[parentIndex] > items[position]) {
                swap(parentIndex, position);
                siftUp(parentIndex);
            }
        }
    }

    void siftDown(int position) {
        if (position * 2 + 1 < items.length) {
            int leftChildIndex = position * 2 + 1;
            int rightChildIndex = position * 2 + 2;
            int siftDownIndex = leftChildIndex;

            if (rightChildIndex != items.length && items[rightChildIndex] < items[leftChildIndex]){
                siftDownIndex = rightChildIndex;
            }

            if (items[position] > items[siftDownIndex]) {
                swap(position, siftDownIndex);
                siftDown(siftDownIndex);
            }
        }
    }

    public int findKthLargest(int[] nums, int k) {
        items = new int[k];
        size = 0;
        for (int num : nums) {
            if (size < k) {
                items[size] = num;
                siftUp(size);
                size += 1;
            } else if (num >= items[0]) {
                items[0] = items[size - 1];
                size -= 1;
                siftDown(0);

                items[size] = num;
                siftUp(size);
                size += 1;
            }
            for (int n : items) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
        return items[0];
    }

}
