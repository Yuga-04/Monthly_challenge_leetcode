class Solution {
    public void mark(int[][] grid, int r, int c, int m, int n) {
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        for (int[] d : dirs) {
            int x = r + d[0], y = c + d[1];
            while (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != -1 && grid[x][y] != 1) {
                if (grid[x][y] == 0) grid[x][y] = 2;
                x += d[0];
                y += d[1];
            }
        }
    }

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        for (int[] g : guards) grid[g[0]][g[1]] = 1;
        for (int[] w : walls) grid[w[0]][w[1]] = -1;

        for (int[] g : guards) mark(grid, g[0], g[1], m, n);

        int cnt = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 0) cnt++;
        return cnt;
    }
} 
