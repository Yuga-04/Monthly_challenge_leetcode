class Solution {
    public int longestSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 1. Find the maximum value in the array.
        int maxVal = 0;
        for (int num : nums) {
            if (num > maxVal) {
                maxVal = num;
            }
        }
        
        // 2. Find the length of the longest subarray of maxVal.
        int maxLen = 0;
        int currentLen = 0;
        
        for (int num : nums) {
            if (num == maxVal) {
                currentLen++;
            } else {
                maxLen = Math.max(maxLen, currentLen);
                currentLen = 0;
            }
        }
        
        // 3. Final check for a trailing streak.
        return Math.max(maxLen, currentLen);
    }
} 
