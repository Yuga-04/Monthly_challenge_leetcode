class Solution {
   public static boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        for (int i = 0; i < n; ++i) {
            if (i == n-1) return true;
            if (bits[i] == 1) ++i;
        }
        return false;
    }
} 
