//Question : https://leetcode.com/problems/apply-operations-to-an-array/description/
class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        
        // Apply operations
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        
        // Shift zeros to the end (in-place)
        int nonZeroIdx = 0;
        
        // Move all non-zero elements to the front
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIdx++] = nums[i];
            }
        }
        
        // Fill the remaining positions with zeros
        while (nonZeroIdx < n) {
            nums[nonZeroIdx++] = 0;
        }
        
        return nums;
    }
}
