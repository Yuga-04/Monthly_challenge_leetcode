class Solution {
    public long flowerGame(int n, int m) {
        int odd1 = (n + 1) / 2;
        int even1 = n / 2;

        int odd2 = (m + 1) / 2;
        int even2 = m / 2;

        return 1L * odd1 * even2 + 1L * odd2 * even1;
    }
} 
