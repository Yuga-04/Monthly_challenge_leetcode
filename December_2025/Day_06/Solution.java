class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length, MOD = 1_000_000_007;
        long[] dp = new long[n + 1];
        dp[0] = 1;

        java.util.Deque<Integer> mx = new java.util.ArrayDeque<>();
        java.util.Deque<Integer> mn = new java.util.ArrayDeque<>();
        long sum = 0;
        int l = 0;

        for (int r = 0; r < n; r++) {
            while (!mx.isEmpty() && nums[mx.peekLast()] <= nums[r]) mx.pollLast();
            while (!mn.isEmpty() && nums[mn.peekLast()] >= nums[r]) mn.pollLast();
            mx.add(r);
            mn.add(r);

            while (nums[mx.peek()] - nums[mn.peek()] > k) {
                if (mx.peek() == l) mx.poll();
                if (mn.peek() == l) mn.poll();
                sum = (sum - dp[l] + MOD) % MOD;
                l++;
            }

            sum = (sum + dp[r]) % MOD;
            dp[r + 1] = sum;
        }
        return (int) dp[n];
    }
} 
