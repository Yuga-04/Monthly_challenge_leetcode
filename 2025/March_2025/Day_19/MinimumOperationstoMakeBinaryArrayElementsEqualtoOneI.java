//Question : https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/description/
class Solution {
    public int minOperations(int[] nums) {
        int size=nums.length,count=0;
        for(int i=0;i<=size-3;i++){
            if(nums[i]==0){
                nums[i]=1;
                nums[i+1]=(nums[i+1]==0)?1:0;
                nums[i+2]=(nums[i+2]==0)?1:0;
                count++;
            }
        }
            for(int i:nums)
              if(i==0)
                return -1;
        return count;
    }
}
