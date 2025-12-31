class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        List<Integer>[] g1 = buildGraph(edges1, n);
        List<Integer>[] g2 = buildGraph(edges2, m);
        if (k == 0) {
            int[] ans = new int[n];
            Arrays.fill(ans, 1);
            return ans;
        }
        int[] cnt1 = bfsCount(g1, k);
        int[] cnt2 = bfsCount(g2, k - 1);
        int best2 = 0;
        for (int x : cnt2) best2 = Math.max(best2, x);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = cnt1[i] + best2;
        }
        return ans;
    }

    private List<Integer>[] buildGraph(int[][] edges, int sz) {
        @SuppressWarnings("unchecked")
        List<Integer>[] g = new List[sz];
        for (int i = 0; i < sz; i++) g[i] = new ArrayList<>();
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g[u].add(v);
            g[v].add(u);
        }
        return g;
    }

    private int[] bfsCount(List<Integer>[] g, int K) {
        int N = g.length;
        int[] result = new int[N], visited = new int[N];
        int stamp = 1;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int start = 0; start < N; start++, stamp++) {
            if (K < 0) {
                result[start] = 1;
                continue;
            }
            queue.clear();
            queue.add(start);
            visited[start] = stamp;
            int level = 0, count = 1;
            while (!queue.isEmpty() && level < K) {
                int sz = queue.size();
                for (int i = 0; i < sz; i++) {
                    int u = queue.poll();
                    for (int v : g[u]) {
                        if (visited[v] != stamp) {
                            visited[v] = stamp;
                            queue.add(v);
                            count++;
                        }
                    }
                }
                level++;
            }
            result[start] = count;
        }
        return result;
    }
} 
