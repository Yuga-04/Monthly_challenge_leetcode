//Question : https://leetcode.com/problems/count-subarrays-with-fixed-bounds/description/

class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;
        int bad = -1, left = -1, right = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) bad = i;
            if (nums[i] == minK) left = i;
            if (nums[i] == maxK) right = i;
            res += Math.max(0, Math.min(left, right) - bad);
        }

        return res;
    }
}
