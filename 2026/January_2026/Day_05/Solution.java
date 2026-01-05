class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int c = 0;
        int mini = Integer.MAX_VALUE;
        int n = matrix.length;
        int m = matrix[0].length;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                sum += Math.abs(matrix[i][j]);
                if(matrix[i][j] < 0) c++;
                mini = Math.min(mini, Math.abs(matrix[i][j]));
            }
        }
        
        if(c % 2 == 1) sum -= 2 * mini;
        
        return sum;
    }
} 
