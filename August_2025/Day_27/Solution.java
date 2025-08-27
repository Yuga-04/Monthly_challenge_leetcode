/**
Time Complexity: O(mn)
Space Complexity: O(mn)
 */
class Solution {
    private static final int[][] DIRS = { { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };

    public int lenOfVDiagonal(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // Too many dimensions affect efficiency, so compress k and canTurn into one int
        int[][][] memo = new int[m][n][1 << 3];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }
                int[] maxs = { m - i, j + 1, i + 1, n - j }; //Theoretical maximum (go to the boundary)
                for (int k = 0; k < 4; k++) { // Enumerate starting direction
                    // Optimization 1: If the theoretical maximum does not exceed ans, skip recursion
                    if (maxs[k] > ans) { 
                        ans = Math.max(ans, dfs(i, j, k, 1, 2, grid, memo) + 1);
                    }
                }
            }
        }
        return ans;
    }

    private int dfs(int i, int j, int k, int canTurn, int target, int[][] grid, int[][][] memo) {
        i += DIRS[k][0];
        j += DIRS[k][1];
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != target) {
            return 0;
        }
        int mask = k << 1 | canTurn;
        if (memo[i][j][mask] > 0) {
            return memo[i][j][mask];
        }
        int res = dfs(i, j, k, canTurn, 2 - target, grid, memo);
        if (canTurn == 1) {
            int[] maxs = { grid.length - i - 1, j, i, grid[i].length - j - 1 }; // Theoretical maximum (go to the boundary)
            k = (k + 1) % 4;
            // Optimization 2: If the theoretical maximum does not exceed res, skip recursion
            if (maxs[k] > res) {
                res = Math.max(res, dfs(i, j, k, 0, 2 - target, grid, memo));
            }
        }
        return memo[i][j][mask] = res + 1;
    }
} 
