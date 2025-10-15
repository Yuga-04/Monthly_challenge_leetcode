class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int up = 1, preUp = 0, res = 0;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                up++;
            } else {
                preUp = up;
                up = 1;
            }
            int half = up >> 1;
            int min = preUp < up ? preUp : up;
            int candidate = half > min ? half : min;
            if (candidate > res) res = candidate;
        }
        return res;
    }
} 
