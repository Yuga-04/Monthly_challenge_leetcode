class Solution {
    private static int[] seen = new int[100001];
    private static int leet = 0;
    public int longestBalanced(int[] nums) {
        leet++; 
        int n = nums.length;
        int res = 0;

        for (int i = 0; i < n && n - i > res; i++) {
            int[] A = new int[2];
            int marker = (leet << 16) | (i + 1);
            for (int j = i; j < n; j++) {
                int val = nums[j];
                if (seen[val] != marker) {
                    seen[val] = marker;
                    A[val & 1]++;
                }

                if (A[0] == A[1])
                    res = Math.max(res, j - i + 1);
            }
        }

        return res;
    }
}
 
