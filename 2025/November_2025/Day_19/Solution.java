class Solution {
    public int findFinalValue(int[] nums, int original) {
        boolean[] memo = new boolean[1001];
        
        for (int x : nums) {
            if (x <= 1000) memo[x] = true;
        }

        int x = original;
        while (x <= 1000) {
            if (memo[x]) x *= 2;
            else break;
        }

        return x;
    }
} 
