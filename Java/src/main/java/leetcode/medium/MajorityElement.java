package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int len = nums.length;

        for (int num : nums) {
            int newFreq = freq.getOrDefault(num, 0) + 1;
            if (newFreq > len / 2) {
                return num;
            }
            freq.put(num, newFreq);
        }
        return 0;
    }
}
