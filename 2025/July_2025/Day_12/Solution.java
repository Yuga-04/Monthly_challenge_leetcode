class Solution {
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        int left = Math.min(firstPlayer, secondPlayer);
        int right = Math.max(firstPlayer, secondPlayer);

        if (left + right == n + 1) {
            return new int[] { 1, 1 };
        }

        if (n == 3 || n == 4) {
            return new int[] { 2, 2 };
        }

        if (left - 1 > n - right) {
            int temp = n + 1 - left;
            left = n + 1 - right;
            right = temp;
        }

        int nextRound = (n + 1) / 2;
        int minRound = n;
        int maxRound = 1;

        if (right * 2 <= n + 1) {
            int preLeft = left - 1;
            int midGap = right - left - 1;
            for (int i = 0; i <= preLeft; i++) {
                for (int j = 0; j <= midGap; j++) {
                    int[] res = earliestAndLatest(nextRound, i + 1, i + j + 2);
                    minRound = Math.min(minRound, 1 + res[0]);
                    maxRound = Math.max(maxRound, 1 + res[1]);
                }
            }
        } else {
            int mirrored = n + 1 - right;
            int preLeft = left - 1;
            int midGap = mirrored - left - 1;
            int innerGap = right - mirrored - 1;
            for (int i = 0; i <= preLeft; i++) {
                for (int j = 0; j <= midGap; j++) {
                    int[] res = earliestAndLatest(nextRound, i + 1, i + j + 1 + (innerGap + 1) / 2 + 1);
                    minRound = Math.min(minRound, 1 + res[0]);
                    maxRound = Math.max(maxRound, 1 + res[1]);
                }
            }
        }
        return new int[] { minRound, maxRound };
    }
} 
