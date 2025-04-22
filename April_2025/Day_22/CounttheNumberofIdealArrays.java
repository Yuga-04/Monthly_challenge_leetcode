//Question : https://leetcode.com/problems/count-the-number-of-ideal-arrays/description/

class Solution {
    int MOD = 1000000007;
    int[][] cnt = new int[10001][14];
    int[][] comb = new int[10001][14];

    public Solution() {
        for (int s = 0; s < 10001; s++) {
            for (int r = 0; r <= Math.min(s, 13); r++) {
                comb[s][r] = (r == 0 || r == s) ? 1 : (comb[s - 1][r - 1] + comb[s - 1][r]) % MOD;
            }
        }

        for (int div = 1; div < 10001; div++) {
            cnt[div][0]++;
            for (int i = div * 2; i < 10001; i += div) {
                for (int bars = 0; bars < 13; bars++) {
                    if (cnt[div][bars] > 0)
                        cnt[i][bars + 1] += cnt[div][bars];
                }
            }
        }
    }

    public int idealArrays(int n, int maxValue) {
        int res = 0;
        for (int i = 1; i <= maxValue; i++) {
            for (int bars = 0; bars < Math.min(14, n); bars++) {
                res = (int)((res + 1L * cnt[i][bars] * comb[n - 1][bars]) % MOD);
            }
        }
        return res;
    }
}
