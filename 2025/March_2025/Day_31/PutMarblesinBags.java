//Question : https://leetcode.com/problems/put-marbles-in-bags/description/
class Solution {
     static public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        int[] adjacentSums = new int[n - 1];
        for (int i = 0; i < n - 1; i++) adjacentSums[i] = weights[i] + weights[i + 1];
        Arrays.sort(adjacentSums);
        long minSum = 0, maxSum = 0;
        for (int i = 0; i < k - 1; i++) minSum += adjacentSums[i];
        for (int i = n - 2; i >= n - k; i--) maxSum += adjacentSums[i];
        return maxSum - minSum;
    }
}
