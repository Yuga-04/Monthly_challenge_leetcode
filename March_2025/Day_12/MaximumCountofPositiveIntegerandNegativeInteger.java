// Question : https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/description/
class Solution {
    public int maximumCount(int[] nums) {
        int pos = 0, neg = 0;
        for (int n : nums) {
            if (n > 0)
                pos++;
            else if (n < 0)
                neg++;
        }

        return Math.max(pos, neg);
    }
}
