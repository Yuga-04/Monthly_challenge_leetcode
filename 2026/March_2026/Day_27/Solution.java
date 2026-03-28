 
class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i % 2 == 0) {
                    if (mat[i][j] != mat[i][(j - k % n + n) % n]) {
                        return false;
                    }
                } else {
                    if (mat[i][j] != mat[i][(j + k % n) % n]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
