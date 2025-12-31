//Question : https://leetcode.com/problems/minimum-operations-to-make-array-values-equal-to-k/description/

class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> garr=new HashSet<>();
        Set<Integer> sarr=new HashSet<>();
        for(int n:nums){
            if(n>k) garr.add(n);
            else if(n==k) sarr.add(n);
            else return -1;
        }
        if(garr.size()==0 && sarr.size()==1) return 0;
        return garr.size();
    }
}
