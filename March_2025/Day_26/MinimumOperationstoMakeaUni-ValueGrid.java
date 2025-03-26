// Question : https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/description/

class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int arr[] = new int[m * n];
        int k = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                arr[k++] = grid[i][j];
        Arrays.sort(arr);
        int mid = arr[(m * n) / 2];
        for (int val : arr) {
            if ((Math.abs(val - mid)) % x != 0)
                return -1;
            count += Math.abs(val - mid) / x;
        }
        return count;
    }
}
