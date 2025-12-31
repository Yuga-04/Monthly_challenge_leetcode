//Question : https://leetcode.com/problems/longest-nice-subarray/description/
class Solution {
    public int longestNiceSubarray(int[] nums) {
        int maxLength = 0;
        int orValue = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            
            while ((orValue & nums[right]) != 0) {
                orValue ^= nums[left];
                left++;
            }

            orValue |= nums[right];
            
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
