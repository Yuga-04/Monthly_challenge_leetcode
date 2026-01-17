class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long maxSide = 0;
        int n = bottomLeft.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Find intersection boundaries
                // Use Math.max for lower bounds (left, bottom)
                // Use Math.min for upper bounds (right, top)
                int x1 = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                int y1 = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                int x2 = Math.min(topRight[i][0], topRight[j][0]);
                int y2 = Math.min(topRight[i][1], topRight[j][1]);

                // Width and Height of the intersection rectangle
                long width = x2 - x1;
                long height = y2 - y1;

                // If valid intersection (width and height > 0)
                if (width > 0 && height > 0) {
                    long side = Math.min(width, height);
                    maxSide = Math.max(maxSide, side);
                }
            }
        }

        return maxSide * maxSide;
    }
} 
