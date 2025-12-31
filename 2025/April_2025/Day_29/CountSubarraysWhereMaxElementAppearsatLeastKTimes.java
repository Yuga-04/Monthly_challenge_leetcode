//Auestion : http://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/description/

class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxElement = Arrays.stream(nums).max().getAsInt();
        long res = 0;
        int left = 0, maxiCount = 0;
        
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == maxElement) maxiCount++;
            while (maxiCount == k) {
                res += nums.length - right;
                if (nums[left] == maxElement) maxiCount--;
                left++;
            }
        }
        
        return res;
    }
}
