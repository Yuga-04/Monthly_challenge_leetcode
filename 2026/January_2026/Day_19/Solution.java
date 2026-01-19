class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        
        int[][] P = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                P[i][j] = mat[i-1][j-1] + P[i-1][j] + P[i][j-1] - P[i-1][j-1];
            }
        }
        
        int maxSide = 0;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int len = maxSide + 1;
                
                if (i >= len && j >= len) {
                    int r1 = i - len + 1;
                    int c1 = j - len + 1;
                    
                    // Calculate sum of square defined by (r1, c1) and (i, j)
                    int total = P[i][j] - P[r1-1][j] - P[i][c1-1] + P[r1-1][c1-1];
                    
                    if (total <= threshold) {
                        maxSide++;
                    }
                }
            }
        }
        
        return maxSide;
    }
} 
