// Question : https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-ii/description/

class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        int[] firstTerm = new int[n];

        int best = nums[0];
        for (int j = 1; j < n; j++) {
            firstTerm[j] = best - nums[j];
            best = Math.max(best, nums[j]);
        }

        int bestFirstTerm = firstTerm[1];
        long result = 0;

        for (int k = 2; k < n; k++) {
            result = Math.max(result, (long)bestFirstTerm * nums[k]);
            bestFirstTerm = Math.max(bestFirstTerm, firstTerm[k]);
        } 

        return result;
    }
}
