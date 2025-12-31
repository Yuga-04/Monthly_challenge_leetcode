//Question : https://leetcode.com/problems/count-the-number-of-fair-pairs/description/

import java.util.Arrays;
class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return countPairsWithSumLessThan(nums, upper + 1) - countPairsWithSumLessThan(nums, lower);
    }

    private long countPairsWithSumLessThan(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        long count = 0;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                count += (right - left);
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}
