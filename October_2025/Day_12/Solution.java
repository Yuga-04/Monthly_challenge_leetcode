class Solution {
    static final int MOD = 1_000_000_007, MAX = 31;
    static final long[] FACT = new long[MAX], INV_FACT = new long[MAX];

    static {
        FACT[0] = 1;
        for (int i = 1; i < MAX; i++) FACT[i] = FACT[i - 1] * i % MOD;
        INV_FACT[MAX - 1] = pow(FACT[MAX - 1], MOD - 2);
        for (int i = MAX - 1; i > 0; i--) INV_FACT[i - 1] = INV_FACT[i] * i % MOD;
    }

    static long pow(long x, int n) {
        long res = 1;
        for (; n > 0; n >>= 1, x = x * x % MOD)
            if ((n & 1) == 1) res = res * x % MOD;
        return res;
    }

    public int magicalSum(int m, int k, int[] nums) {
        int n = nums.length;
        int[][] pows = new int[n][m + 1];
        for (int i = 0; i < n; i++) {
            pows[i][0] = 1;
            for (int j = 1; j <= m; j++)
                pows[i][j] = (int) ((long) pows[i][j - 1] * nums[i] % MOD);
        }

        int[][][][] memo = new int[n][m + 1][m / 2 + 1][k + 1];
        for (int[][][] a : memo)
            for (int[][] b : a)
                for (int[] c : b)
                    Arrays.fill(c, -1);

        return (int) (dfs(0, m, 0, k, pows, memo) * FACT[m] % MOD);
    }

    long dfs(int i, int mLeft, int carry, int kLeft, int[][] pows, int[][][][] memo) {
        int ones = Integer.bitCount(carry);
        if (ones + mLeft < kLeft) return 0; // agar baaki bits se k banana possible nahi toh return 0
        if (i == pows.length) return (mLeft == 0 && ones == kLeft) ? 1 : 0; // base case check
        if (memo[i][mLeft][carry][kLeft] != -1) return memo[i][mLeft][carry][kLeft]; // memo use karo

        long res = 0;
        for (int j = 0; j <= mLeft; j++) {
            int bit = (carry + j) & 1; // current bit nikala (odd/even)
            if (bit <= kLeft) { // agar bit useful hai
                long r = dfs(i + 1, mLeft - j, (carry + j) >> 1, kLeft - bit, pows, memo);
                res = (res + r * pows[i][j] % MOD * INV_FACT[j]) % MOD; // result add karo
            }
        }
        return memo[i][mLeft][carry][kLeft] = (int) res;
    }
} 
