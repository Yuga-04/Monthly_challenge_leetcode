class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0) return 0;
        
        int m = heightMap.length;
        int n = heightMap[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[m][n];
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int water = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m-1 || j == 0 || j == n-1) {
                    pq.offer(new int[]{i, j, heightMap[i][j]});
                    visited[i][j] = true;
                }
            }
        }

        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int x = cell[0], y = cell[1], h = cell[2];

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    
                    if (heightMap[nx][ny] < h) {
                        water += h - heightMap[nx][ny];
                    }
                    
                    pq.offer(new int[]{nx, ny, Math.max(heightMap[nx][ny], h)});
                }
            }
        }

        return water;
    }
} 
