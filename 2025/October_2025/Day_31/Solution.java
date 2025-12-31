class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        boolean[] a = new boolean[n];
        int[] ar = new int[2];
        int k = 0;
        for(int i = 0;i<n;i++){
            if(a[nums[i]]==true) ar[k++] = nums[i];
            else a[nums[i]] = true;
        }
        return ar;
    }
} 
