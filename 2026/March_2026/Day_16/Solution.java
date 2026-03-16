class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] diag1 = new int[m + 1][n + 1];
        int[][] diag2 = new int[m + 1][n + 2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diag1[i + 1][j + 1] = diag1[i][j] + grid[i][j];
                diag2[i + 1][j] = diag2[i][j + 1] + grid[i][j];
            }
        }

        TreeSet<Integer> top3 = new TreeSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                top3.add(grid[i][j]);
                if (top3.size() > 3) {
                    top3.pollFirst(); // remove smallest
                }

                for (int k = 1; i - k >= 0 && i + k < m && j - k >= 0 && j + k < n; k++) {
                    int topR = i - k, topC = j;
                    int rightR = i, rightC = j + k;
                    int bottomR = i + k, bottomC = j;
                    int leftR = i, leftC = j - k;

                    long border = 0;

                    // top -> right   (\)
                    border += diag1[rightR + 1][rightC + 1] - diag1[topR][topC];

                    // right -> bottom (/)
                    border += diag2[bottomR + 1][bottomC] - diag2[rightR][rightC + 1];

                    // left -> bottom  (\)
                    border += diag1[bottomR + 1][bottomC + 1] - diag1[leftR][leftC];

                    // top -> left     (/)
                    border += diag2[leftR + 1][leftC] - diag2[topR][topC + 1];

                    // corners counted twice
                    border -= grid[topR][topC];
                    border -= grid[rightR][rightC];
                    border -= grid[bottomR][bottomC];
                    border -= grid[leftR][leftC];

                    top3.add((int) border);
                    if (top3.size() > 3) {
                        top3.pollFirst(); // remove smallest
                    }
                }
            }
        }

        int[] ans = new int[top3.size()];
        int idx = 0;
        for (int val : top3.descendingSet()) {
            ans[idx++] = val;
        }
        return ans;
    }
} 
