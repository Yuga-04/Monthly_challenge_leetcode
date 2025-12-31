class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        int[] indegree = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        
        // Initialize graph
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            graph.get(from).add(to);
            indegree[to]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[][] dp = new int[n][26];
        int processed = 0;
        int maxColorValue = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            processed++;

            int colorIndex = colors.charAt(node) - 'a';
            dp[node][colorIndex]++;
            maxColorValue = Math.max(maxColorValue, dp[node][colorIndex]);

            for (int neighbor : graph.get(node)) {
                for (int c = 0; c < 26; c++) {
                    dp[neighbor][c] = Math.max(dp[neighbor][c], dp[node][c]);
                }

                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return processed == n ? maxColorValue : -1;
    }
}
