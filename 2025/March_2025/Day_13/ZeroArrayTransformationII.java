//Question : https://leetcode.com/problems/zero-array-transformation-ii/description/
class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] line = new int[n + 1];
        int decrement = 0, k = 0;
        for (int i = 0; i < n; i++) {
            while (decrement + line[i] < nums[i]) { 
                if (k == queries.length) return -1;
                int li = queries[k][0], ri = queries[k][1], vali = queries[k][2];
                k++;
                if (ri < i) continue; 
                line[Math.max(li, i)] += vali;
                line[ri + 1] -= vali;
            }
            decrement += line[i];
        }
        return k;
    }
}
