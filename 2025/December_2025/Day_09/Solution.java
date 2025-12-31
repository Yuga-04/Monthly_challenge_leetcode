class Solution {
    public int specialTriplets(int[] nums) {
        long count = 0;
        int MOD = 1_000_000_007;
        
        // Since constraints say nums[i] <= 10^5, we can use arrays instead of HashMap for speed
        int[] leftFreq = new int[200001]; 
        int[] rightFreq = new int[200001];
        
        // Initialize rightFreq with all elements
        for (int num : nums) {
            rightFreq[num]++;
        }
        
        for (int num : nums) {
            // Remove current element from right (it's the center 'j' now)
            rightFreq[num]--;
            
            // Check for valid 'i' and 'k' values (target = num * 2)
            long target = (long)num * 2;
            if (target <= 200000) {
                long leftCount = leftFreq[(int)target];
                long rightCount = rightFreq[(int)target];
                
                count = (count + leftCount * rightCount) % MOD;
            }
            
            // Add current element to left (it will be on left for next iteration)
            leftFreq[num]++;
        }
        
        return (int) count;
    }
}
 
