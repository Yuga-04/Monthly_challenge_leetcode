import java.util.*;

class Solution {
    private int check(int[] nums, int n, int t, int m) {
        long nL = n;
        long tL = t;
        int l = lowerBound(nums, nL);
        int h = upperBound(nums, nL);
        int ll = lowerBound(nums, nL - tL);
        int hh = upperBound(nums, nL + tL);
        int res = (hh - h) + (l - ll);
        return Math.min(m, res) + (h - l);
    }

    private int lowerBound(int[] arr, long target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    private int upperBound(int[] arr, long target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] <= target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    public int maxFrequency(int[] nums, int k, int numOperations) {
        int m = numOperations;
        Arrays.sort(nums);
        int ans = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            ans = Math.max(ans, check(nums, nums[i], k, m));
            ans = Math.max(ans, check(nums, nums[i] - k, k, m));
            ans = Math.max(ans, check(nums, nums[i] + k, k, m));
        }
        return ans;
    }
} 
