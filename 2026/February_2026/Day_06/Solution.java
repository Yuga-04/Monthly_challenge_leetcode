class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length, max_w_zise = 1;
        Arrays.sort(nums);

        int right = 0;
        for (int left = 0; left < n; left++) {
            while (right < n && nums[right] <= k * (long)nums[left]) right++;

            int w_size = right - left;
            max_w_zise = Math.max(max_w_zise, w_size);
        }

        return n - max_w_zise;
    }
} 
