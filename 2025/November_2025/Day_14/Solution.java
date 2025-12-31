class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] mat = new int[n][n];

        for (int[] q : queries) {
            int r1 = q[0], c1 = q[1], r2 = q[2], c2 = q[3];
            for (int r = r1; r <= r2; r++) {
                for (int c = c1; c <= c2; c++) {
                    mat[r][c]++;
                }
            }
        }
        return mat;
    }
} 
