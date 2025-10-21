class Solution {
    public int maxFrequency(int[] nums, int k, int ops) {
        int mx = Arrays.stream(nums).max().getAsInt();
        int n = mx + k + 2;
        int[] f = new int[n];
        for (int x : nums) f[x]++;

        int[] pre = new int[n];
        pre[0] = f[0];
        for (int i = 1; i < n; i++) pre[i] = pre[i - 1] + f[i];

        int ans = 0;
        for (int t = 0; t < n; t++) {
            if (f[t] == 0 && ops == 0) continue;
            int l = Math.max(0, t - k), r = Math.min(n - 1, t + k);
            int tot = pre[r] - (l > 0 ? pre[l - 1] : 0);
            int adj = tot - f[t];
            int val = f[t] + Math.min(ops, adj);
            ans = Math.max(ans, val);
        }
        return ans;
    }
}
 
