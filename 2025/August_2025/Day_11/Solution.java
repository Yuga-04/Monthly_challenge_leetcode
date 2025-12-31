import java.util.*;

class Solution {
    final int MOD = 1000000007;

    public int[] productQueries(int n, int[][] queries) {
        List<Integer> powers = new ArrayList<>();
        int power = 1;

        while (n > 0) {
            if ((n & 1) == 1) {
                powers.add(power);
            }
            power <<= 1;
            n >>= 1;
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int p = 1;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                p = (int)(((long)p * powers.get(j)) % MOD);
            }
            result[i] = p;
        }

        return result;
    }
} 
