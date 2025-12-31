import java.util.*;

class Solution {
    public int numberOfPairs(int[][] points) {
        // Sort by x ascending, y descending
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(b[1], a[1]);
            return Integer.compare(a[0], b[0]);
        });

        int n = points.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            int top = points[i][1];
            int bot = Integer.MIN_VALUE;

            for (int j = i + 1; j < n; j++) {
                int y = points[j][1];
                if (bot < y && y <= top) {
                    result++;
                    bot = y;
                    if (bot == top) break;
                }
            }
        }

        return result;
    }
} 
