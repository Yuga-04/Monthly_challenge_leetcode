class Solution {
    public int minTimeToReach(final int[][] moveTime) {
        final int n = moveTime.length, m = moveTime[0].length;
        final Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        final int[][] dp = new int[n][m];
        final int[][] directions = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        for(final int[] d : dp)
            Arrays.fill(d, Integer.MAX_VALUE);

        queue.offer(new int[] { 0, 0, 0, 1 });
        moveTime[0][0] = 0;

        while(!queue.isEmpty()) {
            final int[] curr = queue.poll();
            final int i = curr[0], j = curr[1], t = curr[2], cost = curr[3];

            if(i == n - 1 && j == m - 1)
                return t;

            if(dp[i][j] <= t)
                continue;

            dp[i][j] = t;

            for(final int[] direction : directions) {
                final int x = i + direction[0], y = j + direction[1];

                if(x < n && y < m && x >= 0 && y >= 0 && dp[x][y] == Integer.MAX_VALUE) {
                    final int newTime = Math.max(t, moveTime[x][y]) + cost;
                    queue.offer(new int[] { x, y, newTime, cost == 1 ? 2 : 1 });
                }
            }
        }

        return -1;
    }
}