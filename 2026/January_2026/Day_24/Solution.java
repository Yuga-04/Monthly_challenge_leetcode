class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1, ans = 0;
        while (i < j) {
            ans = Math.max(ans, nums[i] + nums[j]);
            i++;
            j--;
        }
        return ans;
    }
} 
