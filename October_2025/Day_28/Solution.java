class Solution {
    private boolean simulate(int[] nums, int start, int dir) {
        int n = nums.length;
        int[] a = nums.clone();
        int curr = start;
        while (curr >= 0 && curr < n) {
            if (a[curr] == 0) {
                curr += dir;
            } else {
                a[curr]--;
                dir = -dir;
                curr += dir;
            }
        }
        for (int v : a)
            if (v != 0)
                return false;
        return true;
    }

    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] != 0)
                continue;
            if (simulate(nums, i, -1))
                ans++;
            if (simulate(nums, i, +1))
                ans++;
        }
        return ans;
    }

} 
