class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[1] - b[1]); 
        int n = events.length;

        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            int[] event = events[i - 1];
            int prev = binarySearch(events, event[0]);

            for (int j = 1; j <= k; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[prev + 1][j - 1] + event[2]);
            }
        }
        return dp[n][k];
    }
    private int binarySearch(int[][] events, int currentStart) {
        int left = 0, right = events.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (events[mid][1] < currentStart) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
} 
