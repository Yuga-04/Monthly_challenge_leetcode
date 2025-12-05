class Solution {
    public int countPartitions(int[] nums) {
        int totalSum = 0;
        for (int i=0;i<nums.length;i++) {
            totalSum += nums[i]; 
        }

        int leftSum = 0;
        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) { 
            leftSum += nums[i]; 
            int rightSum = totalSum - leftSum; 
  
            if ((leftSum % 2) == (rightSum % 2)) {
                count++; 
            }
        }
        return count; 
    }
    } 
