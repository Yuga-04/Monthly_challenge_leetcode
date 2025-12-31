//Question : https://leetcode.com/problems/count-subarrays-with-score-less-than-k/description/

class Solution {
    public long countSubarrays(int[] nums, long k) {
        long count = 0;
        long sum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (left <= right && sum * (right - left + 1) >= k) {
                sum -= nums[left];
                left++;
            }
         count += (right - left + 1);
        }
        
        return count;
    }
}
