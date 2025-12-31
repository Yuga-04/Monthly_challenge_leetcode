class Solution {
        public int triangularSum(int[] nums) {
        for (int n = nums.length; n > 0; --n) {
            for (int i = 1; i < n; ++i) {
                nums[i - 1] += nums[i];
                nums[i - 1] %= 10;
            }
        }
        return nums[0];
    }
} 
