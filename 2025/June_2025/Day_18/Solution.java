class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n=nums.length;
        int [][]grid=new int [n/3][3];
        
        // Sort the input array so we can group close values together
        Arrays.sort(nums);
        
        int v=0;

        // Fill the grid with consecutive triplets from the sorted array
        for(int i=0;i<n/3;i++){
            for(int j=0;j<3;j++){
                grid[i][j]=nums[v++];
            }
        }

        // Check each group to ensure max - min <= k
        for(int i=0;i<n/3;i++){
            int x=grid[i][0],y=grid[i][1],z=grid[i][2];
            if((z-x)>k){
                // If any group's range exceeds k, return empty result
                return new int[0][0];
            }
        }

        // All groups are valid
        return grid;
    }
} 
