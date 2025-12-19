class Solution {
    public void dfs(int x, HashMap<Integer,List<Integer>> adj, boolean[] vis) {
        vis[x] = true;
        List<Integer> neig = adj.get(x);
        for(int i=0;i<neig.size();i++) {
            if(!vis[neig.get(i)]) {
                dfs(neig.get(i), adj, vis);
            }
        }
    }
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[n];
        vis[0] = vis[firstPerson] = true;
        Arrays.sort(meetings, (a,b) -> Integer.compare(a[2],b[2]));
        int i=0;
        while(i < meetings.length) {
            int time = meetings[i][2];
            HashMap<Integer,List<Integer>> adj = new HashMap<>();
            HashSet<Integer> secret = new HashSet<>();
            while(i< meetings.length && meetings[i][2] == time) {
                int x = meetings[i][0];
                int y = meetings[i][1];
                if(!adj.containsKey(x)) adj.put(x, new ArrayList<>());
                if(!adj.containsKey(y)) adj.put(y, new ArrayList<>());
                adj.get(x).add(y);
                adj.get(y).add(x);

                if(vis[x]) secret.add(x);
                if(vis[y]) secret.add(y);
                i++;
            }
            for(int s : secret) {
                dfs(s, adj, vis);
            }
        }
        for(int j=0;j<n;j++) {
            if(vis[j])
                ans.add(j);
        }
        return ans;
    }
} 
