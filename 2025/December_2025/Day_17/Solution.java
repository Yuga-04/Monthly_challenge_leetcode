class Solution {
    int n, K;
    int[] prices;
    Long[][][] dp;
    final long NEG = (long)-1e18;

    long dfs(int i, int t, int state) {
        if (i == n) {
            return state == 0 ? 0 : NEG;
        }

        if (dp[i][t][state] != null)
            return dp[i][t][state];

        long ans = dfs(i + 1, t, state);

        if (state == 0) {
            ans = Math.max(ans, dfs(i + 1, t, 1) - prices[i]);
            ans = Math.max(ans, dfs(i + 1, t, 2) + prices[i]);
        }
        else if (state == 1 && t < K) {
            ans = Math.max(ans, dfs(i + 1, t + 1, 0) + prices[i]);
        }
        else if (state == 2 && t < K) {
            ans = Math.max(ans, dfs(i + 1, t + 1, 0) - prices[i]);
        }

        return dp[i][t][state] = ans;
    }

    public long maximumProfit(int[] prices, int k) {
        this.prices = prices;
        this.n = prices.length;
        this.K = k;

        dp = new Long[n + 1][k + 1][3];
        return dfs(0, 0, 0);
    }
} 
