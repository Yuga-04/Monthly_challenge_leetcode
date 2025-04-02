//Question : https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-i/description/
class Solution {
    public long maximumTripletValue(int[] nums) {
       long  max=Long.MIN_VALUE,val=0;
       int n=nums.length;
       for(int i=0;i<n;i++)
       for(int j=i+1;j<n;j++)
       for(int k=j+1;k<n;k++){
        val = (long)(nums[i] - nums[j]) * nums[k];
        max=Math.max(max,val);
       }
       return (max>0)?max:0;
    }
}
