class Solution {
    public int countPermutations(int[] nums) {
        int MOD = (int)1e9 + 7;
        int n = nums.length;
        int mini = Integer.MAX_VALUE;
        for (int num : nums) {
            mini = Math.min(mini, num);
        }

        if (nums[0] != mini) return 0;

        int cnt = 0;
        for (int num : nums) {
            if (num == mini) cnt++;
            if (cnt > 1) return 0;
        }

        long ans = 1;
        for (int i = 1; i < n; i++) {
            ans = (ans * i) % MOD;
        }

        return (int)ans;
    }
} 
