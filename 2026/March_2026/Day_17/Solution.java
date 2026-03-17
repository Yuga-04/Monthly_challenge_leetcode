class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int max_area = 0;
        
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (matrix[i][j] == 1 && i > 0) {
        			matrix[i][j] = matrix[i - 1][j] + 1;
        		}
        	} 
        	
        	int[] heights = matrix[i].clone();
        	
        	Arrays.sort(heights);
        	
        	for (int j = n - 1; j >= 0; j--) {
        		if (heights[j] == 0) break;
        		
        		int width = n - j;
        		int height = heights[j];
        		
        		max_area = Math.max(max_area, width * height);
        	}
        }
        
       return max_area;
    }
} 
