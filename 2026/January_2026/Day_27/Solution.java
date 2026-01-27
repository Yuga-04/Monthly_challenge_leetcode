import java.util.*;

class Solution {
    public int minCost(int n, int[][] edges) {
        List<List<int[]>> out = new ArrayList<>();
        List<List<int[]>> in = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            out.add(new ArrayList<>());
            in.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            out.get(e[0]).add(new int[]{e[1], e[2]});
            in.get(e[1]).add(new int[]{e[0], e[2]});
        }

        long INF = (long) 1e18;
        long[][] dist = new long[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
        }

        PriorityQueue<long[]> pq =
            new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        dist[0][0] = 0;
        pq.add(new long[]{0, 0, 0}); // cost, node, used

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long cost = cur[0];
            int u = (int) cur[1];
            int used = (int) cur[2];

            if (cost > dist[u][used]) continue;

            // Normal edges
            for (int[] edge : out.get(u)) {
                int v = edge[0];
                int w = edge[1];
                if (dist[v][0] > cost + w) {
                    dist[v][0] = cost + w;
                    pq.add(new long[]{dist[v][0], v, 0});
                }
            }

            // Reversed edges (only if switch unused)
            if (used == 0) {
                for (int[] edge : in.get(u)) {
                    int v = edge[0];
                    int w = edge[1];
                    if (dist[v][0] > cost + 2L * w) {
                        dist[v][0] = cost + 2L * w;
                        pq.add(new long[]{dist[v][0], v, 0});
                    }
                }
            }
        }

        long ans = Math.min(dist[n - 1][0], dist[n - 1][1]);
        return ans >= INF ? -1 : (int) ans;
    }
} 
