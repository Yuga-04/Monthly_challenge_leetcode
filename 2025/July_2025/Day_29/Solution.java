class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int len = nums.length;
        int[] lastSeen = new int[30];
        int[] res = new int[len];
        for (int i = 0; i < len; i++) res[i] = 1;
        for (int i = len - 1; i >= 0; i--) {
            for (int bit = 0; bit < 30; bit++) {
                if ((nums[i] & (1 << bit)) > 0) lastSeen[bit] = i;
                res[i] = Math.max(res[i], lastSeen[bit] - i + 1);
            }
        }
        return res;
    }
} 
