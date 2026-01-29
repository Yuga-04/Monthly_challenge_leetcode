import java.util.*;

class Solution {
    private void dijkstra(int src, List<int[]>[] adj, int[] dist) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        dist[src] = 0;
        pq.offer(new int[]{0, src});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0], u = cur[1];

            if (d > dist[u]) continue;

            for (int[] edge : adj[u]) {
                int v = edge[0], w = edge[1];
                if (dist[v] > d + w) {
                    dist[v] = d + w;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }
    }

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        if (source.length() != target.length()) return -1;

        List<int[]>[] adj = new ArrayList[26];
        for (int i = 0; i < 26; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < original.length; i++) {
            adj[original[i] - 'a'].add(new int[]{changed[i] - 'a', cost[i]});
        }

        int[][] dist = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dijkstra(i, adj, dist[i]);
        }

        long ans = 0;
        for (int i = 0; i < source.length(); i++) {
            int u = source.charAt(i) - 'a';
            int v = target.charAt(i) - 'a';
            if (u == v) continue;
            if (dist[u][v] == Integer.MAX_VALUE) return -1;
            ans += dist[u][v];
        }

        return ans;
    }
} 
