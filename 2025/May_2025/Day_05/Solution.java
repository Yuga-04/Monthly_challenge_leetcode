class Solution {
    public int numTilings(int n) {
        long[] dp = new long[Math.max(4, n + 1)];
        int MOD = 1_000_000_007;
        dp[1] = 1; dp[2] = 2; dp[3] = 5;
        for (int i = 4; i <= n; i++) {
            dp[i] = (2 * dp[i - 1] + dp[i - 3]) % MOD;
        }
        return (int) dp[n];
    }
}