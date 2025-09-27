class Solution {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double area = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                for(int k = j+1; k < n; k++) {
                    double temp = 0.5 * Math.abs(points[k][0] *(points[i][1]-points[j][1]) 
                                   + points[i][0] *(points[j][1]-points[k][1]) 
                                   + points[j][0] *(points[k][1]-points[i][1]));
                    area = Math.max(temp, area);
                }
            }
        }

        return area;
    }
} 
