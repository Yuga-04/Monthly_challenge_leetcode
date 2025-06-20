import java.util.*;

class Solution {
    public int minimizeMax(int[] v, int p) {
        Arrays.sort(v); // Sort to ensure smallest differences come first
        int n = v.length;
        int lo = -1, hi = (int)1e9 + 7;

        while (lo < hi - 1) {
            int mid = lo + (hi - lo) / 2;
            int count = 0;

            for (int i = 1; i < n; i++) {
                if (v[i] - v[i - 1] <= mid) {
                    count++;
                    i++; // Skip next to ensure non-overlapping
                }
            }

            if (count >= p) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        return hi;
    }
} 
