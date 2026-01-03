class Solution {
    public int numOfWays(int n) {
        final int MOD = 1_000_000_007;
        long A = 6, B = 6;
        
        for (int i = 2; i <= n; i++) {
            long newA = (2 * A + 2 * B) % MOD;
            long newB = (2 * A + 3 * B) % MOD;
            A = newA;
            B = newB;
        }
        
        return (int) ((A + B) % MOD);
    }
} 
