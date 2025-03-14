//Question : https://leetcode.com/problems/maximum-candies-allocated-to-k-children/description/
class Solution {
    private boolean solve(int res, int[] candies, long k) {
        long cnt = 0;
        for (int candy : candies) {
            cnt += candy / res;
        }
        return cnt >= k;
    }
    
    public int maximumCandies(int[] candies, long k) {
        long sum = 0;
        for (int candy : candies) {
            sum += candy;
        }
        if (sum < k) {
            return 0;
        }
        
        int low = 1;
        int high = 0;
        for (int candy : candies) {
            high = Math.max(high, candy);
        }
        int ans = low;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (solve(mid, candies, k)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
