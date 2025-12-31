class Solution {
    public int maxFrequencyElements(int[] nums) {
        int freq[] = new int[101];
        int maxFreq = 0;
        for (int num : nums) {
            freq[num]++;
            maxFreq = Math.max(maxFreq, freq[num]);
        }

        int ans = 0;
        for (int i = 1; i <= 100; i++) {
            if (freq[i] == maxFreq) ans += maxFreq;
        }
        return ans;
    }
} 
