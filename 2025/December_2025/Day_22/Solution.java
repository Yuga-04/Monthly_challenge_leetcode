class Solution {
    public int minDeletionSize(String[] strs) {
        int m = strs[0].length();
        // dp[i] stores the max length of an increasing subsequence ending at index i
        int[] dp = new int[m];
        int maxKept = 0;

        for (int i = 0; i < m; i++) {
            dp[i] = 1; // Initialize with 1 (the column itself)
            for (int j = 0; j < i; j++) {
                // Check if column j can precede column i
                if (isSorted(strs, j, i)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxKept = Math.max(maxKept, dp[i]);
        }

        return m - maxKept;
    }

    private boolean isSorted(String[] strs, int j, int i) {
        for (String s : strs) {
            // Compare characters at index j and i for every string
            if (s.charAt(j) > s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
