/* https://leetcode.com/problems/shuffle-the-array/ */

((nums, n) => {
    for (let idx = 1; idx < n; idx += 1) {
        let tmp = nums[idx];
        nums[idx] = nums[idx + (n - 1)];
        nums[idx + (n - 1)] = tmp;
    }
    return nums;
})();
