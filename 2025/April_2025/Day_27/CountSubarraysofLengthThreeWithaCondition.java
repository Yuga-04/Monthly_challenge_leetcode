//Question : https://leetcode.com/problems/count-subarrays-of-length-three-with-a-condition/description/

class Solution {
    public int countSubarrays(int[] nums) {
        int count=0,n=nums.length;
        for(int i=0;i<n-2;i++){
            if((nums[i]+nums[i+2])*2==nums[i+1]) count++;
        }
        return count;
    }
}
