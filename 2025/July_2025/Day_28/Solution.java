class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for (int n : nums) maxOr |= n;
        return dfs(nums, 0, 0, maxOr);
    }

    private int dfs(int[] nums, int index, int currOr, int maxOr) {
        if (index == nums.length) return currOr == maxOr ? 1 : 0;
        int include = dfs(nums, index + 1, currOr | nums[index], maxOr);
        int exclude = dfs(nums, index + 1, currOr, maxOr);
        return include + exclude;
    }
} 
