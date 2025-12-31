import java.util.*;

class Solution {
    public int maximumLength(int[] nums, int k) {
        int maxLength = 2;

        for (int targetMod = 0; targetMod < k; targetMod++) {
            int[] remainderDP = new int[k];

            for (int num : nums) {
                int numMod = num % k;
                int requiredMod = (targetMod - numMod + k) % k;
                remainderDP[numMod] = remainderDP[requiredMod] + 1;
            }

            for (int length : remainderDP) {
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
} 
