 
class Solution {
    private static final int MOD = 1000000007;
    public int numberOfPaths(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        if (n == 1 || m == 1) {
            int ts = 0;
            for (int[] row: grid) {
                for (int x: row) {
                    ts += x;
                }
            }
            return (ts % k == 0) ? 1 : 0;
        }
        int[][][] dp = new int[n][m][k];
        dp[0][0][grid[0][0] % k] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) continue;
                int v = grid[i][j] % k;
                for (int q = 0; q < k; q++) {
                    int r = (q + v) % k;
                    int res = 0;
                    if (i > 0) {
                        res += dp[i-1][j][q];
                    }
                    if (j > 0) {
                        res += dp[i][j-1][q];
                    }
                    dp[i][j][r] = (dp[i][j][r] + res) % MOD;
                }
            }
        }
        return dp[n-1][m-1][0];
    }
}
