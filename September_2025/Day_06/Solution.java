class Solution {
    public long minOperations(int[][] queries) {
        long ans = 0;
        for (int[] q : queries) {
            int l = q[0], r = q[1];
            long S = 0;
            int dMax = 0;

            for (int k = 1; k <= 31; k++) {
                long low = 1L << (k - 1);
                long high = (1L << k) - 1;
                if (low > r) break;
                long a = Math.max((long)l, low);
                long b = Math.min((long)r, high);
                if (a > b) continue;
                long cnt = b - a + 1;
                int stepsForK = (k + 1) / 2;
                S += cnt * stepsForK;
                dMax = Math.max(dMax, stepsForK);
            }

            long ops = Math.max((long)dMax, (S + 1) / 2);
            ans += ops;
        }
        return ans;
    }
} 
