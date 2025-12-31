//Question : https://leetcode.com/problems/count-the-hidden-sequences/description/

class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long minPrefix = 0, maxPrefix = 0, sum = 0;

        for (int diff : differences) {
            sum += diff;
            minPrefix = Math.min(minPrefix, sum);
            maxPrefix = Math.max(maxPrefix, sum);
        }

        long minStart = lower - minPrefix;
        long maxStart = upper - maxPrefix;

        return (int)Math.max(0, maxStart - minStart + 1);
    }
}
