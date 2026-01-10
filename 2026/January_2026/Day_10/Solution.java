class Solution {
    int[][] dp;

    int solve(String s1, String s2, int i, int j) {
        if (i >= s1.length() && j >= s2.length()) {
            return 0;
        }

        if (i >= s1.length()) {
            int sum = 0;
            for (int k = j; k < s2.length(); k++) {
                sum += s2.charAt(k);
            }
            return sum;
        }

        if (j >= s2.length()) {
            int sum = 0;
            for (int k = i; k < s1.length(); k++) {
                sum += s1.charAt(k);
            }
            return sum;
        }

        if (dp[i][j] != -1) return dp[i][j];

        int ans;
        if (s1.charAt(i) == s2.charAt(j)) {
            ans = solve(s1, s2, i + 1, j + 1);
        } else {
            int deleteS1 = s1.charAt(i) + solve(s1, s2, i + 1, j);
            int deleteS2 = s2.charAt(j) + solve(s1, s2, i, j + 1);
            ans = Math.min(deleteS1, deleteS2);
        }

        return dp[i][j] = ans;
    }

    public int minimumDeleteSum(String s1, String s2) {
        dp = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(s1, s2, 0, 0);
    }
} 
