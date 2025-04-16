//Question : https://leetcode.com/problems/count-the-number-of-good-subarrays/description/

import java.util.HashMap;

class Solution {
    public long countGood(int[] nums, int k) {
        long cnt = 0;
        int l = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // Subtract current frequency from k
            int val = nums[i];
            k -= mp.getOrDefault(val, 0);
            mp.put(val, mp.getOrDefault(val, 0) + 1);

            // Shrink window until we have less than k pairs
            while (k <= 0) {
                int leftVal = nums[l];
                mp.put(leftVal, mp.get(leftVal) - 1);
                k += mp.get(leftVal);
                l++;
            }

            // Count all good subarrays ending at i
            cnt += l;
        }

        return cnt;
    }
}
