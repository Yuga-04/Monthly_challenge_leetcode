class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int cnt = 0;
        int[][] dp = new int[n][m];

        // Initialize first column
        for (int i = 0; i < n; i++) {
            dp[i][0] = matrix[i][0];
        }
        // Initialize first row
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }

        // Fill DP table
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],
                                    Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        // Count all squares
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cnt += dp[i][j];
            }
        }

        return cnt;
    }
} 
