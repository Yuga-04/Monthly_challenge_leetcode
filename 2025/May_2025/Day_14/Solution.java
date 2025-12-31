class Solution {
    private static final int K = 26;
    private static final int MOD = 1_000_000_007;

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        long[] freq = new long[K];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        long[][] base = new long[K][K];
        for (int i = 0; i < K; i++) {
            int steps = nums.get(i);
            for (int k = 1; k <= steps; k++) {
                base[i][(i + k) % K]++;
            }
        }
        long[][] mt = matrixPower(base, t);
        long ans = 0;
        for (int i = 0; i < K; i++) {
            long fi = freq[i];
            if (fi == 0) continue;
            for (int j = 0; j < K; j++) {
                ans = (ans + fi * mt[i][j]) % MOD;
            }
        }

        return (int)ans;
    }

    private long[][] matrixPower(long[][] M, int exp) {
        long[][] res = new long[K][K];
        for (int i = 0; i < K; i++) {
            res[i][i] = 1;
        }
        long[][] base = M;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = multiply(res, base);
            }
            base = multiply(base, base);
            exp >>= 1;
        }
        return res;
    }
    private long[][] multiply(long[][] A, long[][] B) {
        long[][] C = new long[K][K];
        for (int i = 0; i < K; i++) {
            for (int k = 0; k < K; k++) {
                long aik = A[i][k];
                if (aik == 0) continue;
                for (int j = 0; j < K; j++) {
                    C[i][j] = (C[i][j] + aik * B[k][j]) % MOD;
                }
            }
        }
        return C;
    }
}