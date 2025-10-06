class Solution {
    public int swimInWater(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        
        int lo = grid[0][0], hi = 0;
        for (int[] row : grid)
            for (int val : row)
                hi = Math.max(hi, val);
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (possible(grid, mid, m, n, directions)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
    
    private boolean possible(int[][] grid, int mid, int m, int n, int[][] directions) {
        if (grid[0][0] > mid) return false;
        boolean[][] seen = new boolean[m][n];
        return dfs(grid, 0, 0, mid, seen, m, n, directions);
    }
    
    private boolean dfs(int[][] grid, int r, int c, int mid, boolean[][] seen, int m, int n, int[][] directions) {
        if (r == m-1 && c == n-1) return true;
        seen[r][c] = true;
        
        for (int[] dir : directions) {
            int nr = r + dir[0], nc = c + dir[1];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && !seen[nr][nc]) {
                if (grid[nr][nc] <= mid) {
                    if (dfs(grid, nr, nc, mid, seen, m, n, directions)) return true;
                }
            }
        }
        return false;
    }
} 
