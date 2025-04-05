//Question : https://leetcode.com/problems/sum-of-all-subset-xor-totals/description/

class Solution {
    public int subsetXORSum(int[] nums) {
        int n = nums.length, total = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            int subsetXor = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subsetXor ^= nums[i];
                }
            }
            total += subsetXor;
        }
        return total;
    }
}
