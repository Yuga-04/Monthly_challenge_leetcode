class Solution {
    public int maxArea(int[] h) {
        int n = h.length;
        int i = 0, j = n - 1;
        int ans = 0;
        while (i < j) {
            int x = Math.min(h[i], h[j]);
            ans = Math.max(ans, x * (j - i));
            if (h[i] > h[j]) {
                j--;
            } else {
                i++;
            }
        }
        return ans;
    }
} 
