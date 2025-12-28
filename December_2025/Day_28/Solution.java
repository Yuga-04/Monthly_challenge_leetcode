class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int countNegs = 0;
        int row = 0;
        int col = n - 1;

        while(row < m && col >= 0) {
            if(grid[row][col] < 0) {
                countNegs += (m - row);
                col--;
            } else {
                row++;
            }
        }

        return countNegs;
    }
}	 
