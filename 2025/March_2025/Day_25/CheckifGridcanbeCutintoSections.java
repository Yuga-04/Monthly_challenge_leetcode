//Question : https://leetcode.com/problems/check-if-grid-can-be-cut-into-sections/description/

import java.util.*;

class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        return canCut(rectangles, 0) || canCut(rectangles, 1);
    }

    private boolean canCut(int[][] rectangles, int axis) {
        Arrays.sort(rectangles, Comparator.comparingInt(a -> a[axis]));
        int cuts = 0, previousEnd = -1;

        for (int[] rect : rectangles) {
            int start = rect[axis], end = rect[axis + 2];

            if (start >= previousEnd) cuts++;
            previousEnd = Math.max(previousEnd, end);
            if (cuts >= 3) return true;
        }

        return false;
    }
}
