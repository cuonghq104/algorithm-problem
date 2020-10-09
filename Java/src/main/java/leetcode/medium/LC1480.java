package leetcode.medium;

/**
 * https://leetcode.com/problems/running-sum-of-1d-array/
 */
public class LC1480 {

    public int[] runningSum(int[] nums) {

        for (int i = 1; i < nums.length; i += 1) {
            nums[i] = nums[i] + nums[i - 1];
        }

        return nums;
    }
}
