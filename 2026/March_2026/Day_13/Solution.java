class Solution {
    public long minNumberOfSeconds(int height, int[] times) {
        long lo = 1, hi = 10000000000000000L;

        while (lo < hi) {
            long mid = (lo + hi) >> 1;
            long tot = 0;
            for (int i = 0; i < times.length && tot < height; i++)
                tot += (long) (Math.sqrt((double) mid / times[i] * 2 + 0.25) - 0.5);
            if (tot >= height)
                hi = mid;
            else
                lo = mid + 1;
        }

        return lo;
    }
} 
