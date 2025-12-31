class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        
        for (int len = 3; len <= n; len++) { 
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i + 1; k < j; k++) {
                    int cost = dp[i][k] + dp[k][j] + values[i] * values[k] * values[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[0][n - 1];
    }
}
 
