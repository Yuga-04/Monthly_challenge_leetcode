class Solution {
    public int minCost(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int INF = Integer.MAX_VALUE / 2;

        int[][] dp = new int[m][n];

        // initialize dp
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                dp[i][j] = INF;

        dp[0][0] = 0;

        // initial DP (no optimization)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (i > 0) dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + grid[i][j]);
                if (j > 0) dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + grid[i][j]);
            }
        }

        // k optimization rounds
        for (int t = 0; t < k; t++) {
            int MAX = 10001;
            int[] best = new int[MAX];
            Arrays.fill(best, INF);

            // collect best cost for each value
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    best[grid[i][j]] = Math.min(best[grid[i][j]], dp[i][j]);
                }
            }

            // suffix minimum
            for (int v = MAX - 2; v >= 0; v--) {
                best[v] = Math.min(best[v], best[v + 1]);
            }

            int[][] ndp = new int[m][n];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    ndp[i][j] = INF;

            ndp[0][0] = 0;

            // rebuild DP
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) continue;

                    ndp[i][j] = best[grid[i][j]];
                    if (i > 0) ndp[i][j] = Math.min(ndp[i][j], ndp[i - 1][j] + grid[i][j]);
                    if (j > 0) ndp[i][j] = Math.min(ndp[i][j], ndp[i][j - 1] + grid[i][j]);
                }
            }

            dp = ndp;
        }

        return dp[m - 1][n - 1];
    }
} 
