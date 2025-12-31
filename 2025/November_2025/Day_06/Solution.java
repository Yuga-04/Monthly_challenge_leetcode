class Solution 
{
    static class DSU 
    {
        int[] parent;

        DSU(int n) 
        {
            // Step 1: Initialize DSU
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++)
            {
                parent[i] = i;
            }
        }

        int find(int x) 
        {
            if (parent[x] != x)
            {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y) 
        {
            int px = find(x);
            int py = find(y);

            // Step 2: Union operation to connect components
            if (px != py)
            {
                parent[py] = px;
            }
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) 
    {
        // Step 1: Initialize DSU for all nodes
        DSU dsu = new DSU(c);

        // Step 2: Merge connected nodes into single components
        for (int[] conn : connections)
        {
            dsu.union(conn[0], conn[1]);
        }

        // Step 3: Build map of root → ordered set of nodes
        HashMap<Integer, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 1; i <= c; i++) 
        {
            int root = dsu.find(i);
            map.computeIfAbsent(root, k -> new TreeSet<>()).add(i);
        }

        // Step 4: Initialize offline tracker and result list
        boolean[] isOffline = new boolean[c + 1];
        ArrayList<Integer> res = new ArrayList<>();

        // Step 5: Process each query
        for (int[] query : queries) 
        {
            int type = query[0];
            int node = query[1];

            if (type == 1) 
            {
                // Step 6: Handle type-1 (query smallest online node)
                if (!isOffline[node]) 
                {
                    res.add(node);
                } 
                else 
                {
                    int root = dsu.find(node);
                    TreeSet<Integer> online = map.get(root);
                    Integer min = (online == null || online.isEmpty()) ? null : online.first();
                    res.add(min == null ? -1 : min);
                }
            } 
            else 
            {
                // Step 7: Handle type-2 (mark node offline)
                if (!isOffline[node]) 
                {
                    isOffline[node] = true;
                    int root = dsu.find(node);
                    TreeSet<Integer> online = map.get(root);
                    if (online != null)
                    {
                        online.remove(node);
                    }
                }
            }
        }

        // Step 8: Convert result to array
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
        {
            ans[i] = res.get(i);
        }

        return ans;
    }
} 
