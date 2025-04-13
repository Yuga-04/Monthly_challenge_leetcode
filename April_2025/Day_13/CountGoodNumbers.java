// Question : https://leetcode.com/problems/count-good-numbers/description/

class Solution {
    private static final int MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;
        long evenChoices = modPow(5, evenCount, MOD);
        long oddChoices = modPow(4, oddCount, MOD);
        return (int)((evenChoices * oddChoices) % MOD);
    }

    private long modPow(long base, long exponent, int mod) {
        long result = 1;
        base %= mod;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exponent >>= 1;
        }
        return result;
    }
}
