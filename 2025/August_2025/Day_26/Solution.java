class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxArea = Integer.MIN_VALUE;
        int maxDiagonal = Integer.MIN_VALUE;
        int n = dimensions.length;
        
        for( int i = 0; i < n; i++ ){
            int l = dimensions[i][0];
            int w = dimensions[i][1];
            int currDiagonal = l * l + w * w;

            if( currDiagonal > maxDiagonal ||  (currDiagonal == maxDiagonal && l * w > maxArea) ) {
                maxDiagonal = currDiagonal;
                maxArea = l * w;
            }
        }
        return maxArea;
    }
} 
