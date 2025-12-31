class Solution {
    int mod = (int)(1e9 + 7);

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] dp = new long[n + 1];  // dp[i] = number of people who learn the secret on day i
        dp[1] = 1;

        long noOfPeopleWithSecret = 0; // running count of people who can share

        for (int i = 2; i <= n; i++) {
            // People who learned 'delay' days ago start sharing today
            long noOfNewPeopleWithSecret = 0;
            if (i - delay >= 1)
                noOfNewPeopleWithSecret = dp[i - delay];

            // People who learned 'forget' days ago forget today
            long noOfPeopleForgetSecret = 0;
            if (i - forget >= 1)
                noOfPeopleForgetSecret = dp[i - forget];

            // Update active sharers
            noOfPeopleWithSecret = (noOfPeopleWithSecret + noOfNewPeopleWithSecret - noOfPeopleForgetSecret + mod) % mod;

            // The number of new people learning today equals the number of people sharing
            dp[i] = noOfPeopleWithSecret;
        }

        // Sum up those who still remember on day n
        long ans = 0;
        for (int i = n - forget + 1; i <= n; i++) {
            if (i >= 1) ans = (ans + dp[i]) % mod;
        }
        return (int) ans;
    }
} 
