class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long[] minPrefix = new long[k];
        final long INF = Long.MAX_VALUE;

        for (int i = 0; i < k; i++) minPrefix[i] = INF;
        minPrefix[0] = 0;

        long prefix = 0;
        long answer = Long.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            int mod = (i + 1) % k;

            if (minPrefix[mod] != INF) {
                answer = Math.max(answer, prefix - minPrefix[mod]);
            }

            minPrefix[mod] = Math.min(minPrefix[mod], prefix);
        }

        return answer;
    }
}
 
